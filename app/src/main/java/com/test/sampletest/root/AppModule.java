package com.test.sampletest.root;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.sampletest.di.AppScope;
import com.test.sampletest.service.APIInterfaceService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @AppScope
    Gson providesGson(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    @Provides
    @AppScope
    Retrofit providesRetrofit(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    @Provides
    @AppScope
    APIInterfaceService provideAPInterfaceService(Gson gson, Retrofit retrofit){
        APIInterfaceService apiInterfaceService = new APIInterfaceService(gson, retrofit);
        return apiInterfaceService;
    }


}
