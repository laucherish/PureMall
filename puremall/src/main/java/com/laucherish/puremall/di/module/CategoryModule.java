package com.laucherish.puremall.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import com.laucherish.puremall.mvp.contract.CategoryContract;
import com.laucherish.puremall.mvp.model.CategoryModel;


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
@Module
public abstract class CategoryModule {

    @Binds
    abstract CategoryContract.Model bindCategoryModel(CategoryModel model);
}