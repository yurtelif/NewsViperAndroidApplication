package com.yrtelf.newsviper.feature.source;

import com.yrtelf.newsviper.base.IView;
import com.yrtelf.newsviper.model.Source;

import java.util.List;

public interface ISources {

    interface View extends IView{
        void showErrorMessage(String message);
        void showList(List<Source> response);
        void getSourcesList();
    }

    interface Callback {
        void onGetNewsSourcesSuccess(List<Source> response);
        void onGetNewsSourcesError(String message);
    }

}

