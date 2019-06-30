package com.yrtelf.newsviper.modules;

import com.yrtelf.newsviper.model.api.NewsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public NewsApi providesNewsApi(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }

}