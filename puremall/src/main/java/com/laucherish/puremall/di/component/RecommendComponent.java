package com.laucherish.puremall.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.laucherish.puremall.di.module.RecommendModule;
import com.laucherish.puremall.mvp.contract.RecommendContract;

import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.ui.fragment.RecommendFragment;


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
@FragmentScope
@Component(modules = RecommendModule.class, dependencies = AppComponent.class)
public interface RecommendComponent {
    void inject(RecommendFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        RecommendComponent.Builder view(RecommendContract.View view);

        RecommendComponent.Builder appComponent(AppComponent appComponent);

        RecommendComponent build();
    }
}