package com.test.sampletest.root;

import android.app.Application;

import com.google.gson.Gson;
import com.test.sampletest.service.APIInterfaceService;

import retrofit2.Retrofit;

public class App extends Application {

    APIInterfaceService apiInterfaceService;
    AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

//    public APIInterfaceService getApiInterfaceService(/*Gson gson, Retrofit retrofit*/){
////        apiInterfaceService = new APIInterfaceService(gson, retrofit);
////        return apiInterfaceService;
//
//        return appComponent.getApiInterfaceService();
//    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
