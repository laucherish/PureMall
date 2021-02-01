package com.laucherish.puremall.mvp.ui.activity.product;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportActivity;
import com.laucherish.puremall.app.base.BaseSupportFragment;
import com.laucherish.puremall.di.component.DaggerProductDetailComponent;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;
import com.laucherish.puremall.mvp.presenter.ProductDetailPresenter;
import com.laucherish.puremall.mvp.ui.adapter.ItemTitlePagerAdapter;
import com.laucherish.puremall.mvp.ui.fragment.product.ProductCommentFragment;
import com.laucherish.puremall.mvp.ui.fragment.product.ProductDetailsFragment;
import com.laucherish.puremall.mvp.ui.fragment.product.ProductInfoFragment;
import com.laucherish.puremall.mvp.ui.widget.NoScrollViewPager;
import com.laucherish.puremall.mvp.ui.widget.sku.AddToCartAnimation;
import com.laucherish.puremall.mvp.ui.widget.sku.ProductSkuDialog;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.Product;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.Sku;
import com.laucherish.puremall.mvp.ui.widget.sku.bean.SkuAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * Author : liuyangchi.
 * Description : ProuctDetailActivity.
 * Date : 1/20/21.
 */
public class ProductDetailActivity extends BaseSupportActivity<ProductDetailPresenter> implements ProductDetailContract.View {

    @BindView(R.id.toolbar_back)
    RelativeLayout toolbarBack;
    @BindView(R.id.tab_title)
    TabLayout tabTitle;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.vp_content)
    NoScrollViewPager vpContent;
    @BindView(R.id.btn_add_cart)
    Button btnAddCart;
    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.rl_favorites)
    RelativeLayout rlFavorites;
    @BindView(R.id.iv_shopping_cart)
    ImageView ivShoppingCart;
    @BindView(R.id.tv_shopping_cart_num)
    TextView tvShoppingCartNum;
    @BindView(R.id.rl_cart)
    RelativeLayout rlCart;

    private String productId;
    private ProductSkuDialog dialog;
    private Product product;
    private int shoppingCartNum;

    private List<BaseSupportFragment> baseSupportFragments = new ArrayList<>();
    private String[] titles = {"产品", "参数", "评价"};

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
        if (getIntent() != null && getIntent().hasExtra("productId")) {
            productId = getIntent().getStringExtra("productId");
        }
        initTablayoutAndViewPager();
        if (mPresenter != null) {
            mPresenter.getProductDetail(false, productId);
        }
    }

    private void initTablayoutAndViewPager() {
        tabTitle.addTab(tabTitle.newTab().setText(titles[0]));
        tabTitle.addTab(tabTitle.newTab().setText(titles[1]));
        tabTitle.getTabAt(0).select();
        baseSupportFragments.add(new ProductInfoFragment());
        baseSupportFragments.add(new ProductDetailsFragment());
        baseSupportFragments.add(new ProductCommentFragment());

        vpContent.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                baseSupportFragments, titles));
        tabTitle.setupWithViewPager(vpContent, true);
    }

    public void showTitle(boolean isshow) {
        if (isshow) {
            vpContent.setNoScroll(true);
            tvTitle.setVisibility(View.VISIBLE);
            tabTitle.setVisibility(View.GONE);
        } else {
            vpContent.setNoScroll(false);
            tvTitle.setVisibility(View.GONE);
            tabTitle.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void refreshData(ProductDetailBean detailBean) {
        for (BaseSupportFragment fragment : baseSupportFragments) {
            fragment.setData(detailBean);
        }
        product = transferProduct(detailBean);
    }

    @Override
    public Context getContext() {
        return this;
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

    private void showSkuDialog() {
        if (dialog == null) {
            dialog = new ProductSkuDialog(this);
            dialog.setData(product, new ProductSkuDialog.Callback() {
                @Override
                public void onAdded(Sku sku, int quantity, ImageView ivAddCartAnim) {
                    shoppingCartNum += quantity;
                    tvShoppingCartNum.setVisibility(View.VISIBLE);

                    // 获取SKU面板Logo拷贝
                    ImageView logoImageView = new ImageView(ProductDetailActivity.this);
                    ivAddCartAnim.setDrawingCacheEnabled(true);
                    Bitmap bitmap = Bitmap.createBitmap(ivAddCartAnim.getDrawingCache());
                    logoImageView.setImageBitmap(bitmap);
                    ivAddCartAnim.setDrawingCacheEnabled(false);

                    int[] startLocation = new int[2];
                    ivAddCartAnim.getLocationOnScreen(startLocation);
                    // 执行动画
                    startAddToCartAnimation(logoImageView, startLocation);
                }
            });
        }
        dialog.show();
    }

    @OnClick({R.id.rl_favorites, R.id.rl_cart, R.id.btn_add_cart, R.id.btn_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_favorites:
                break;
            case R.id.rl_cart:
                break;
            case R.id.btn_add_cart:
                showSkuDialog();
                break;
            case R.id.btn_pay:
                break;
        }
    }

    /**
     * ********************************添加到购物车动画***********************************
     */
    private ViewGroup mAnimationMaskLayout;      // 动画浮层

    private ViewGroup buildAddToCartAnimLayout() {
        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;
    }

    private View addViewToCartAnimLayout(View view, int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    private void startAddToCartAnimation(final View v, int[] startLocation) {
        mAnimationMaskLayout = buildAddToCartAnimLayout();
        mAnimationMaskLayout.addView(v);
        final View view = addViewToCartAnimLayout(v, startLocation);
        int[] bottomCartLocation = new int[2];                    // 这是用来存储动画结束位置的X、Y坐标
        ivShoppingCart.getLocationInWindow(bottomCartLocation);

        AddToCartAnimation animation = new AddToCartAnimation(startLocation, bottomCartLocation);
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            // 动画的结束
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
                mAnimationMaskLayout.removeView(v);
                tvShoppingCartNum.setText(String.valueOf(shoppingCartNum));
            }
        });
    }

    private Product transferProduct(ProductDetailBean detailBean) {
        Map<String, Set<String>> map = new HashMap<>();
        for (ProductDetailBean.SpecificationListBean specification : detailBean.specificationList) {
            if (!map.containsKey(specification.name)) {
                map.put(specification.name, new HashSet<String>());
            }
            for (ProductDetailBean.SpecificationListBean.ValueListBean value :
                    specification.valueList) {
                map.get(specification.name).add(value.value);
            }
        }

        Product product = new Product();
        product.setId(String.valueOf(detailBean.info.id));
        product.setName(detailBean.info.name);
        product.setMainImage(detailBean.info.picUrl);
        product.setMeasurementUnit(detailBean.info.unit);
        product.setSellingPrice(detailBean.info.retailPrice);
        List<Sku> skus = new ArrayList<>();
        for (ProductDetailBean.ProductListBean productBean : detailBean.productList) {
            Sku sku = new Sku();
            sku.setId(String.valueOf(productBean.id));
            sku.setStockQuantity(productBean.number);
            sku.setSellingPrice(productBean.price);
            sku.setMainImage(productBean.url);
            List<SkuAttribute> attributes = new ArrayList<>();
            for (String specific : productBean.specifications) {
                SkuAttribute skuAttribute = new SkuAttribute();
                skuAttribute.setValue(specific);
                for (String key : map.keySet()) {
                    if (map.get(key).contains(specific)) {
                        skuAttribute.setKey(key);
                        break;
                    }
                }
                attributes.add(skuAttribute);
            }
            sku.setAttributes(attributes);
            skus.add(sku);
        }
        product.setSkus(skus);
        return product;
    }
}
