package com.yrtelf.newsviper.feature.news;

import com.annimon.stream.Stream;
import com.yrtelf.newsviper.base.BaseInteractor;
import com.yrtelf.newsviper.model.News;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsInteractor extends BaseInteractor {

    @Inject
    public NewsInteractor(){ }

    public void getNews(final INews.Callback callback, String sourceId){
        Disposable disposable = newsApi.getNews(sourceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        newsResponse -> {
                            List<News> newsList = Stream.of(newsResponse.getArticles()).toList();
                            callback.onGetNewsSuccess(newsList);
                        },
                        throwable -> {
                            callback.onGetNewsError(throwable.getMessage());
                            throwable.printStackTrace();
                        }
                );
    }
}
