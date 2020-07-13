package com.laucherish.puremall.mvp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportFragment;
import com.laucherish.puremall.di.component.DaggerRecommendComponent;
import com.laucherish.puremall.mvp.contract.RecommendContract;
import com.laucherish.puremall.mvp.model.entity.IndexBean;
import com.laucherish.puremall.mvp.model.entity.ProductBean;
import com.laucherish.puremall.mvp.presenter.RecommendPresenter;
import com.laucherish.puremall.mvp.ui.adapter.ImageBannerAdapter;
import com.laucherish.puremall.mvp.ui.adapter.RecommendQuickAdapter;
import com.laucherish.puremall.mvp.ui.widget.RecommendItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/02/2020 15:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class RecommendFragment extends BaseSupportFragment<RecommendPresenter> implements RecommendContract.View {

    @BindView(R.id.view_status_bar)
    View viewStatusBar;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.rl_search_bar)
    RelativeLayout rlSearchBar;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.banner_header)
    Banner bannerHeader;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @Inject
    ImageBannerAdapter bannerAdapter;
    @Inject
    List<IndexBean.BannerBean> banners;
    @Inject
    RecommendQuickAdapter adapter;
    @Inject
    List<ProductBean> products;
    @Inject
    RecyclerView.LayoutManager layoutManager;

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerRecommendComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        setStatusBar();
        initAppBar();
        initBanner();
        initRecycler();
        if (mPresenter != null) {
            mPresenter.getRecommend(false);
        }
    }

    private void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), viewStatusBar);
    }

    private void initAppBar() {
        appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            if (verticalOffset >= 0) {
                swipeRefresh.setEnabled(true);
            } else {
                swipeRefresh.setEnabled(false);
            }
            toolBar.setBackgroundColor(changeAlpha(getResources().getColor(R.color.white),
                    Math.abs(verticalOffset * 1.0f) / appBarLayout.getTotalScrollRange()));
        });
    }

    private void initBanner() {
        bannerHeader.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setAdapter(bannerAdapter)
                .setIndicator(new CircleIndicator(getActivity()));
    }

    private void initRecycler() {
        adapter.addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.layout_recommend_for_you, null));
        swipeRefresh.setOnRefreshListener(() -> mPresenter.getRecommend(true));
        swipeRefresh.setProgressViewOffset(true, 130, 300);
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.red));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecommendItemDecoration(ArmsUtils.dip2px(getActivity()
                , 10)));
        recyclerView.setAdapter(adapter);
    }

    private int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }

    /**
     * 通过此方法可以使 Fragment 能够与外界做一些交互和通信, 比如说外部的 Activity 想让自己持有的某个 Fragment 对象执行一些方法,
     * 建议在有多个需要与外界交互的方法时, 统一传 {@link Message}, 通过 what 字段来区分不同的方法, 在 {@link #setData(Object)}
     * 方法中就可以 {@code switch} 做不同的操作, 这样就可以用统一的入口方法做多个不同的操作, 可以起到分发的作用
     * <p>
     * 调用此方法时请注意调用时 Fragment 的生命周期, 如果调用 {@link #setData(Object)} 方法时
     * {@link Fragment#onCreate(Bundle)} 还没执行
     * 但在 {@link #setData(Object)} 里却调用了 Presenter 的方法, 是会报空的, 因为 Dagger 注入是在
     * {@link Fragment#onCreate(Bundle)} 方法中执行的
     * 然后才创建的 Presenter, 如果要做一些初始化操作,可以不必让外部调用 {@link #setData(Object)}, 在
     * {@link #initData(Bundle)} 中初始化就可以了
     * <p>
     * Example usage:
     * <pre>
     * public void setData(@Nullable Object data) {
     *     if (data != null && data instanceof Message) {
     *         switch (((Message) data).what) {
     *             case 0:
     *                 loadData(((Message) data).arg1);
     *                 break;
     *             case 1:
     *                 refreshUI();
     *                 break;
     *             default:
     *                 //do something
     *                 break;
     *         }
     *     }
     * }
     *
     * // call setData(Object):
     * Message data = new Message();
     * data.what = 0;
     * data.arg1 = 1;
     * fragment.setData(data);
     * </pre>
     *
     * @param data 当不需要参数时 {@code data} 可以为 {@code null}
     */
    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        if (swipeRefresh != null && swipeRefresh.isRefreshing())
            swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }

    @Override
    public void refreshData(IndexBean indexBean) {
        // 添加Banner数据
        banners.clear();
        banners.addAll(indexBean.banner);
        bannerAdapter.notifyDataSetChanged();
        bannerHeader.start();
        // 添加产品数据
        products.clear();
        products.addAll(indexBean.newGoodsList);
        products.addAll(indexBean.hotGoodsList);
        adapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }
}
