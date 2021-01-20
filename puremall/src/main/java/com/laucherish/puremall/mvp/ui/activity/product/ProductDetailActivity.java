package com.laucherish.puremall.mvp.ui.activity.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportActivity;
import com.laucherish.puremall.di.component.DaggerProductDetailComponent;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;
import com.laucherish.puremall.mvp.presenter.ProductDetailPresenter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * Author : liuyangchi.
 * Description : ProuctDetailActivity.
 * Date : 1/20/21.
 */
public class ProductDetailActivity extends BaseSupportActivity<ProductDetailPresenter> implements ProductDetailContract.View {

    private String productId;

    public static void startActivity(Context context, String productId) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("productId", productId);
        context.startActivity(intent);
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerProductDetailComponent
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_product_detail;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.getProductDetail(false, productId);
        }
    }

    @Override
    public void refreshData(ProductDetailBean detailBean) {

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

    @Override
    public void killMyself() {
        finish();
    }
}
