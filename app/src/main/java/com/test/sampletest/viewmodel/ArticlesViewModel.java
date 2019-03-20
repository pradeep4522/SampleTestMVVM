package com.test.sampletest.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.repository.ArticlesRepository;

public class ArticlesViewModel extends ViewModel {

    ArticlesRepository articlesRepository;

    public ArticlesViewModel() {
       articlesRepository = new ArticlesRepository();
    }
    public void init() {
        if (popularArticlesMutableLiveData != null){
            return;
        }
        popularArticlesMutableLiveData = articlesRepository.getPopularArticles();

    }

    MutableLiveData<PopularArticles> popularArticlesMutableLiveData;

    public MutableLiveData<PopularArticles> getPopularArticlesData(){
        return  popularArticlesMutableLiveData;
    }

}
