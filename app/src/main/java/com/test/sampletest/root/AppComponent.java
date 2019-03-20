package com.test.sampletest.root;

import com.test.sampletest.di.AppScope;
import com.test.sampletest.service.APIInterfaceService;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@AppScope
public interface AppComponent {
    APIInterfaceService getApiInterfaceService();
}
