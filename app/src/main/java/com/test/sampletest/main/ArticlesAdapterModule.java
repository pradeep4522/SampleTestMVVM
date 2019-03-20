package com.test.sampletest.main;

import com.test.sampletest.di.ActivityScope;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.model.Result;
import com.test.sampletest.repository.ArticlesRepository;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ArticlesAdapterModule {
//    PopularArticles ;
    List<Result> popularArticles;

    public ArticlesAdapterModule(List<Result> popularArticles) {
        this.popularArticles = popularArticles;
    }

    @Provides
    @ActivityScope
    ArticlesAdapter getArticlesAdapter(){
    return new ArticlesAdapter(popularArticles);
    }

}
