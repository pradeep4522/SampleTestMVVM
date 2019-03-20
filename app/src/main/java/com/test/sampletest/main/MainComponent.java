package com.test.sampletest.main;

import com.test.sampletest.di.ActivityScope;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.repository.ArticlesRepository;
import com.test.sampletest.root.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ArticlesAdapterModule.class}, dependencies = AppComponent.class)
@ActivityScope
public interface MainComponent {

    ArticlesAdapter getArticlesAdapter();

    void inject(MainActivity mainActivity);
}
