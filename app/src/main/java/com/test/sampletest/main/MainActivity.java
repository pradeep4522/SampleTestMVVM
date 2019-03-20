package com.test.sampletest.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.sampletest.R;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.model.Result;
import com.test.sampletest.root.App;
import com.test.sampletest.root.AppComponent;
import com.test.sampletest.service.APIInterface;
import com.test.sampletest.service.APIInterfaceService;
import com.test.sampletest.viewmodel.ArticlesViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvArticles;
    @Inject
    ArticlesAdapter adapter;
    MainComponent mainComponent;
    LiveData<PopularArticles> popularArticlesLiveData;
    List<Result> articlesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (android.os.Build.VERSION.SDK_INT > 9)
//        {
//            StrictMode.ThreadPolicy policy = new
//                    StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }


        rvArticles = (RecyclerView) findViewById(R.id.rcv_articles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvArticles.setHasFixedSize(true);
        rvArticles.setLayoutManager(linearLayoutManager);



        ArticlesViewModel articlesViewModel = ViewModelProviders.of(this).get(ArticlesViewModel.class);
        articlesViewModel.init();
        articlesViewModel.getPopularArticlesData().observe(this, new android.arch.lifecycle.Observer<PopularArticles>() {
            @Override
            public void onChanged(@Nullable PopularArticles popularArticles) {
                articlesList.addAll(popularArticles.getResults());
                adapter.notifyDataSetChanged();
            }
        });

        mainComponent = DaggerMainComponent.builder()
                .articlesAdapterModule(new ArticlesAdapterModule(articlesList))
                .appComponent(((App)getApplication()).getAppComponent())
                .build();


       adapter =  mainComponent.getArticlesAdapter();
        mainComponent.inject(MainActivity.this);







        if(articlesList != null) {
            rvArticles.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }


//
//        adapter = mainComponent.getArticlesAdapter();

//        mainComponent.inject(MainActivity.this);





    }
}
