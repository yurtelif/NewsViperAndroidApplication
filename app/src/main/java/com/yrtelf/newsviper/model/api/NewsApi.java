package com.yrtelf.newsviper.model.api;

import com.yrtelf.newsviper.BuildConfig;
import com.yrtelf.newsviper.model.NewsResponse;
import com.yrtelf.newsviper.model.SourceResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v2/sources/?apiKey=" + BuildConfig.API_KEY)
    Single<SourceResponse> getNewsSources();

    @GET("/v2/top-headlines?apiKey=" + BuildConfig.API_KEY)
    Single<NewsResponse> getNews(@Query("sources") String sourceId);


}
