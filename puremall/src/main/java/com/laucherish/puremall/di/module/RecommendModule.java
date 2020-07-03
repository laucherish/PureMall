package com.laucherish.puremall.di.module;

import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.contract.RecommendContract;
import com.laucherish.puremall.mvp.model.RecommendModel;
import com.laucherish.puremall.mvp.model.entity.IndexBean;
import com.laucherish.puremall.mvp.model.entity.ProductBean;
import com.laucherish.puremall.mvp.ui.adapter.ImageBannerAdapter;
import com.laucherish.puremall.mvp.ui.adapter.RecommendQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;


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
@Module
public abstract class RecommendModule {

    @Binds
    abstract RecommendContract.Model bindRecommendModel(RecommendModel model);

    @FragmentScope
    @Provides
    static List<ProductBean> provideProducts() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    static RecommendQuickAdapter provideAdapter(List<ProductBean> products) {
        return new RecommendQuickAdapter(products);
    }

    @FragmentScope
    @Provides
    static List<IndexBean.BannerBean> provideBanners() {
        return new ArrayList<>();
    }

    @FragmentScope
    @Provides
    static ImageBannerAdapter provideBannerAdapter(RecommendContract.View view,
                                                   List<IndexBean.BannerBean> banners) {
        return new ImageBannerAdapter(view.getContext(), banners);
    }

    @FragmentScope
    @Provides
    static RecyclerView.LayoutManager provideLayoutManager(RecommendContract.View view) {
        return new GridLayoutManager(view.getContext(), 2);
    }
}