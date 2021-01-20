package com.laucherish.puremall.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.laucherish.puremall.di.module.ProductDetailModule;
import com.laucherish.puremall.mvp.contract.ProductDetailContract;
import com.laucherish.puremall.mvp.ui.activity.product.ProductDetailActivity;

import dagger.BindsInstance;
import dagger.Component;


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
@ActivityScope
@Component(modules = ProductDetailModule.class, dependencies = AppComponent.class)
public interface ProductDetailComponent {
    void inject(ProductDetailActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ProductDetailComponent.Builder view(ProductDetailContract.View view);

        ProductDetailComponent.Builder appComponent(AppComponent appComponent);

        ProductDetailComponent build();
    }
}