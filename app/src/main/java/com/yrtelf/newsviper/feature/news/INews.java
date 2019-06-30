package com.yrtelf.newsviper.feature.news;

import com.yrtelf.newsviper.base.IView;
import com.yrtelf.newsviper.model.News;


import java.util.List;

public interface INews {

    interface View extends IView{
        void showErrorMessage(String message);
        void showList(List<News> response);
        void getNewsList(String sourceId);
    }

    interface Callback {
        void onGetNewsSuccess(List<News> response);
        void onGetNewsError(String message);
    }
}
