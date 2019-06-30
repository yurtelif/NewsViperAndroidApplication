package com.yrtelf.newsviper.feature.news;

import com.yrtelf.newsviper.base.BasePresenter;
import com.yrtelf.newsviper.model.News;

import java.util.List;

import javax.inject.Inject;

public class NewsPresenter extends BasePresenter<INews.View, NewsInteractor> implements INews.Callback{

    @Inject
    public NewsPresenter(){ };

    public void getNews(String sourceId){
        interactor.getNews(this, sourceId);
    }

    @Override
    public void onGetNewsSuccess(List<News> response) {
        view.showList(response);
    }

    @Override
    public void onGetNewsError(String message) {
        view.showErrorMessage(message);
    }
}

