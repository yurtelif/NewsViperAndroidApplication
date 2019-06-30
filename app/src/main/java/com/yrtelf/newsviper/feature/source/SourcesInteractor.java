package com.yrtelf.newsviper.feature.source;

import android.util.Log;

import com.annimon.stream.Stream;
import com.yrtelf.newsviper.base.BaseInteractor;
import com.yrtelf.newsviper.model.Source;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SourcesInteractor extends BaseInteractor {

    @Inject
    public SourcesInteractor(){ }

    public void getNewsSources(final ISources.Callback callback){
        newsApi.getNewsSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        newsSourceResponse -> {
                            List<Source> sourceList = Stream.of(newsSourceResponse.getSourcesList())
                                    .toList();
                            Log.d("SourcesInteractor", "getNewsSources: ");
                            callback.onGetNewsSourcesSuccess(sourceList);
                        },
                        throwable -> {
                            callback.onGetNewsSourcesError(throwable.getMessage());
                            Log.d("SourcesInteractor", "throw: ");
                            throwable.printStackTrace();
                        }
                );
    }

}


