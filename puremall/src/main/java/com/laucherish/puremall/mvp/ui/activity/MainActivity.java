package com.laucherish.puremall.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportActivity;
import com.laucherish.puremall.app.base.BaseSupportFragment;
import com.laucherish.puremall.di.component.DaggerMainComponent;
import com.laucherish.puremall.mvp.contract.MainContract;
import com.laucherish.puremall.mvp.presenter.MainPresenter;
import com.laucherish.puremall.mvp.ui.fragment.CartFragment;
import com.laucherish.puremall.mvp.ui.fragment.CategoryFragment;
import com.laucherish.puremall.mvp.ui.fragment.MineFragment;
import com.laucherish.puremall.mvp.ui.fragment.RecommendFragment;
import com.laucherish.puremall.mvp.ui.widget.bottombar.BottomBar;
import com.laucherish.puremall.mvp.ui.widget.bottombar.BottomBarTab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/01/2020 19:49
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MainActivity extends BaseSupportActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;

    private BaseSupportFragment[] fragments = new BaseSupportFragment[4];
    private BaseSupportFragment curFragment;
    private BottomBarTab homeTab;
    private BottomBarTab categoryTab;
    private BottomBarTab cartTab;
    private BottomBarTab selfTab;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
//        setStatusBar();
        initBottomBar();
    }

    private void initBottomBar() {
        initFragment();
        homeTab = new BottomBarTab(this, R.drawable.icon_navigation_home, "首页");
        categoryTab = new BottomBarTab(this, R.drawable.icon_navigation_category, "分类");
        cartTab = new BottomBarTab(this, R.drawable.icon_navigation_cart, "购物车");
        selfTab = new BottomBarTab(this, R.drawable.icon_navigation_self, "我的");
        bottomBar.addItem(homeTab)
                .addItem(categoryTab)
                .addItem(cartTab)
                .addItem(selfTab);
        bottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                switchFragment(fragments[position]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void switchFragment(BaseSupportFragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(curFragment)
                    .show(fragment)
                    .commit();
        } else {
            transaction.hide(curFragment)
                    .add(R.id.fragment_contain, fragment, fragment.getClass().getName())
                    .commit();
        }
        curFragment = fragment;
    }

    private void initFragment() {
        fragments[0] = RecommendFragment.newInstance();
        fragments[1] = CategoryFragment.newInstance();
        fragments[2] = CartFragment.newInstance();
        fragments[3] = MineFragment.newInstance();
        curFragment = fragments[0];
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_contain, curFragment, curFragment.getClass().getName())
                .commit();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

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

    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, null);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
