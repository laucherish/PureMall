package com.laucherish.puremall.di.module;

import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.model.ProductDetailModel;

import dagger.Binds;
import dagger.Module;


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
@Module
public abstract class ProductDetailModule {

    @Binds
    abstract ProductDetailContract.Model bindProductDetailModule(ProductDetailModel model);
}