package com.laucherish.puremall.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.laucherish.puremall.mvp.contract.CategoryContract;
import com.laucherish.puremall.mvp.model.api.service.CategoryService;
import com.laucherish.puremall.mvp.model.entity.BaseResponse;
import com.laucherish.puremall.mvp.model.entity.CategoryListBean;

import javax.inject.Inject;

import io.reactivex.Observable;


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
public class CategoryModel extends BaseModel implements CategoryContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public CategoryModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<BaseResponse<CategoryListBean>> getCategoryList() {
        return mRepositoryManager.obtainRetrofitService(CategoryService.class)
                .getCategoryList();
    }

    @Override
    public Observable<BaseResponse<CategoryListBean>> getCategory(int id) {
        return mRepositoryManager.obtainRetrofitService(CategoryService.class)
                .getCategory(id);
    }
}