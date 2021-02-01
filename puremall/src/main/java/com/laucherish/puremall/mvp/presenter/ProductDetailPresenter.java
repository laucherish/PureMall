package com.laucherish.puremall.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.laucherish.puremall.app.utils.RxUtils;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import androidx.core.app.ComponentActivity;
import androidx.fragment.app.Fragment;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;


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
@ActivityScope
public class ProductDetailPresenter extends BasePresenter<ProductDetailContract.Model, ProductDetailContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public ProductDetailPresenter(ProductDetailContract.Model model, ProductDetailContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 使用 2017 Google IO 发布的 Architecture Components 中的 Lifecycles 的新特性 (此特性已被加入 Support library)
     * 使 {@code Presenter} 可以与 {@link ComponentActivity} 和 {@link Fragment} 的部分生命周期绑定
     */
//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    void onCreate() {
//        getRecommend(true);//打开 App 时自动加载列表
//    }

    public void getProductDetail(boolean pullToRefresh, String productId) {
        mModel.getProductDetail(productId)
                .compose(RxUtils.applySchedulers(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<ProductDetailBean>>(mErrorHandler) {
                    @Override
                    public void onNext(@NotNull BaseResponse<ProductDetailBean> response) {
                        if (response.isSuccess()) {
                            mRootView.refreshData(response.getData());
                        } else {
                            mRootView.showMessage(response.getErrmsg());
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }
}
