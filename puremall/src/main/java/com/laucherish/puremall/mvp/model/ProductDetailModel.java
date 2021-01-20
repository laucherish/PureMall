package com.laucherish.puremall.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.model.api.service.ProductService;
import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;

import javax.inject.Inject;

import io.reactivex.Observable;


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
public class ProductDetailModel extends BaseModel implements ProductDetailContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ProductDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<BaseResponse<ProductDetailBean>> getProductDetail(String productId) {
        return mRepositoryManager.obtainRetrofitService(ProductService.class)
                .getProductDetail(productId);
    }
}