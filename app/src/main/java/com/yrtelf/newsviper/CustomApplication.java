package com.yrtelf.newsviper;

import android.app.Application;

import com.yrtelf.newsviper.modules.AndroidModule;
import com.yrtelf.newsviper.modules.ApiModule;
import com.yrtelf.newsviper.modules.NetModule;
import com.yrtelf.newsviper.modules.RetrofitModule;
import com.yrtelf.newsviper.util.NewsSharedPreferences;

public class CustomApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        NewsSharedPreferences.getInstance().init(this);
        appComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule(this))
                .netModule(new NetModule())
                .retrofitModule(new RetrofitModule())
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
