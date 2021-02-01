package com.laucherish.puremall.mvp.ui.fragment.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jess.arms.di.component.AppComponent;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportFragment;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;
import com.laucherish.puremall.mvp.ui.activity.product.ProductDetailActivity;
import com.laucherish.puremall.mvp.ui.adapter.StringBannerAdapter;
import com.laucherish.puremall.mvp.ui.widget.ItemWebView;
import com.laucherish.puremall.mvp.ui.widget.SlideDetailsLayout;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Author 张迁-zhangqian
 * @Data 2018/6/6 下午4:21
 * @Package com.zack.shop.mvp.ui.fragments
 **/
public class ProductInfoFragment extends BaseSupportFragment implements SlideDetailsLayout.OnSlideDetailsListener {

    @BindView(R.id.vp_item_goods_img)
    Banner bannerGoodsImg;
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice;
    @BindView(R.id.tv_user_role)
    TextView tvUserRole;
    @BindView(R.id.tv_goods_title)
    TextView tvGoodsTitle;
    @BindView(R.id.tv_goods_sub_title)
    TextView tvGoodsSubTitle;
    @BindView(R.id.ll_current_goods)
    LinearLayout llCurrentGoods;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.ll_empty_comment)
    LinearLayout llEmptyComment;
    @BindView(R.id.ll_pull_up)
    LinearLayout llPullUp;
    @BindView(R.id.sv_goods_info)
    ScrollView svGoodsInfo;
    @BindView(R.id.sv_switch)
    SlideDetailsLayout svSwitch;
    @BindView(R.id.fab_up_slide)
    FloatingActionButton fabUpSlide;
    @BindView(R.id.webView)
    ItemWebView webView;

    private StringBannerAdapter bannerAdapter;
    private List<String> bannerList;

    public ProductInfoFragment() {

    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                         @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_info, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBanner();
        svSwitch.setOnSlideDetailsListener(this);
        initFab();
    }

    private void initFab() {
        fabUpSlide.hide();
    }

    private void initBanner() {
        bannerList = new ArrayList<>();
        bannerAdapter = new StringBannerAdapter(mContext, bannerList);
        bannerGoodsImg.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setAdapter(bannerAdapter)
                .setIndicator(new CircleIndicator(getActivity()));
    }

    @Override
    public void setData(@Nullable Object data) {
        ProductDetailBean detailBean = (ProductDetailBean) data;
        if (detailBean == null) {
            return;
        }

        // 添加Banner数据
        bannerList.clear();
        bannerList.addAll(detailBean.info.gallery);
        bannerAdapter.notifyDataSetChanged();
        bannerGoodsImg.start();

        tvGoodsTitle.setText(detailBean.info.name);
        tvGoodsSubTitle.setText(detailBean.info.brief);
        tvNewPrice.setText(String.format("%s", detailBean.info.retailPrice));
        tvUserRole.setText(String.format("%s", "普通会员"));
        tvCommentCount.setText(String.format("(%s)", detailBean.comment.count));

        loadData(detailBean.info.detail);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void loadData(String data) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        //不支持屏幕缩放
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        //不显示webView缩放按钮
        webSettings.setDisplayZoomControls(false);

        webView.loadData(getHtmlData(data), "text/html", "utf-8");
    }

    @OnClick({R.id.ll_current_goods, R.id.ll_empty_comment, R.id.ll_pull_up, R.id.sv_switch,
            R.id.fab_up_slide})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_current_goods:
                // 规格数量选择

                break;
            case R.id.ll_empty_comment:
                break;
            case R.id.ll_pull_up:
                //上拉查看图文详情
                svSwitch.smoothOpen(true);
                break;
            case R.id.sv_switch:
                break;
            case R.id.fab_up_slide:
                //点击滑动到顶部
                svGoodsInfo.smoothScrollTo(0, 0);
                svSwitch.smoothClose(true);
                break;
        }
    }

    @Override
    public void onStatusChanged(SlideDetailsLayout.Status status) {
        ProductDetailActivity activity = (ProductDetailActivity) getActivity();
        if (status == SlideDetailsLayout.Status.OPEN) {
            //当前为图文详情页
            fabUpSlide.show();
            activity.showTitle(true);
        } else {
            //当前为商品详情页
            fabUpSlide.hide();
            activity.showTitle(false);
        }
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, " +
                "user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

}
