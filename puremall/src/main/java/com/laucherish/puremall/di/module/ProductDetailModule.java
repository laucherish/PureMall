package com.laucherish.puremall.di.module;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.contract.RecommendContract;
import com.laucherish.puremall.mvp.model.ProductDetailModel;
import com.laucherish.puremall.mvp.model.entity.IndexBean;
import com.laucherish.puremall.mvp.model.entity.ProductDetailBean;
import com.laucherish.puremall.mvp.ui.adapter.ImageBannerAdapter;
import com.laucherish.puremall.mvp.ui.adapter.StringBannerAdapter;

import java.util.ArrayList;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


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

    @ActivityScope
    @Provides
    static List<String> provideBanners() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    static StringBannerAdapter provideBannerAdapter(ProductDetailContract.View view,
                                                    List<String> banners) {
        return new StringBannerAdapter(view.getContext(), banners);
    }
}