package com.laucherish.puremall.mvp.presenter;

import android.app.Application;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.laucherish.puremall.app.utils.RxUtils;
import com.laucherish.puremall.mvp.contract.CategoryContract;
import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.CategoryListBean;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/02/2020 16:37
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
public class CategoryPresenter extends BasePresenter<CategoryContract.Model,
        CategoryContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public CategoryPresenter(CategoryContract.Model model, CategoryContract.View rootView) {
        super(model, rootView);
    }

    public void getCategoryList() {
        mModel.getCategoryList()
                .compose(RxUtils.applySchedulers(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<CategoryListBean>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<CategoryListBean> response) {
                        if (response.isSuccess()) {
                            mRootView.refreshData(response.getData());
                        } else {
                            mRootView.showMessage(response.getErrmsg());
                        }
                    }
                });
    }

    public void getCategory(int id) {
        mModel.getCategory(id)
                .compose(RxUtils.applySchedulers(mRootView))
                .subscribe(new ErrorHandleSubscriber<BaseResponse<CategoryListBean>>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse<CategoryListBean> response) {
                        if (response.isSuccess()) {
                            mRootView.refreshCategory(response.getData());
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
