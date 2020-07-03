package com.laucherish.puremall.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.laucherish.puremall.di.module.CartModule;
import com.laucherish.puremall.mvp.contract.CartContract;

import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.ui.fragment.CartFragment;


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
@Component(modules = CartModule.class, dependencies = AppComponent.class)
public interface CartComponent {
    void inject(CartFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CartComponent.Builder view(CartContract.View view);

        CartComponent.Builder appComponent(AppComponent appComponent);

        CartComponent build();
    }
}