package com.laucherish.puremall.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.laucherish.puremall.di.module.MineModule;
import com.laucherish.puremall.mvp.contract.MineContract;

import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.ui.fragment.MineFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 07/02/2020 16:38
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = MineModule.class, dependencies = AppComponent.class)
public interface MineComponent {
    void inject(MineFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        MineComponent.Builder view(MineContract.View view);

        MineComponent.Builder appComponent(AppComponent appComponent);

        MineComponent build();
    }
}