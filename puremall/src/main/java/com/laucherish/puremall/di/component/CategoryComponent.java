package com.laucherish.puremall.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.laucherish.puremall.di.module.CategoryModule;
import com.laucherish.puremall.mvp.contract.CategoryContract;

import com.jess.arms.di.scope.FragmentScope;
import com.laucherish.puremall.mvp.ui.fragment.CategoryFragment;


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
@Component(modules = CategoryModule.class, dependencies = AppComponent.class)
public interface CategoryComponent {
    void inject(CategoryFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CategoryComponent.Builder view(CategoryContract.View view);

        CategoryComponent.Builder appComponent(AppComponent appComponent);

        CategoryComponent build();
    }
}