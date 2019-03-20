package com.test.sampletest.service;


import com.test.sampletest.model.PopularArticles;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("mostpopular/v2/viewed/7.json")
    Observable<PopularArticles> getMostPopularArticles(@Query("api-key") String apiKey);



}
