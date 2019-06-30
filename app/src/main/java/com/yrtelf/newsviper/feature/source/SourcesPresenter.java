package com.yrtelf.newsviper.feature.source;

import android.util.Log;

import com.yrtelf.newsviper.base.BasePresenter;
import com.yrtelf.newsviper.model.Source;

import java.util.List;

import javax.inject.Inject;

public class SourcesPresenter extends BasePresenter<ISources.View, SourcesInteractor>
        implements ISources.Callback {

    @Inject
    public SourcesPresenter(){ }

    public void getNewsSources(){
        interactor.getNewsSources(this);
    }

    @Override
    public void onGetNewsSourcesSuccess(List<Source> response) {
        view.showList(response);
    }

    @Override
    public void onGetNewsSourcesError(String message) {
        view.showErrorMessage(message);
    }
}


