package com.yrtelf.newsviper;

import com.yrtelf.newsviper.feature.news.NewsActivity;
import com.yrtelf.newsviper.feature.source.SourcesActivity;
import com.yrtelf.newsviper.modules.AndroidModule;
import com.yrtelf.newsviper.modules.ApiModule;
import com.yrtelf.newsviper.modules.NetModule;
import com.yrtelf.newsviper.modules.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        NetModule.class,
        RetrofitModule.class,
        ApiModule.class,
        AndroidModule.class,
})
@Singleton
public interface AppComponent {

    void inject(SourcesActivity activity);

    void inject(NewsActivity activity);


}