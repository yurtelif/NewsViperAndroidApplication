package com.yrtelf.newsviper.feature.source;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.yrtelf.newsviper.R;
import com.yrtelf.newsviper.base.BaseActivity;
import com.yrtelf.newsviper.databinding.ActivityNewsSourceBinding;
import com.yrtelf.newsviper.model.Source;
import com.yrtelf.newsviper.util.UIListeners;

import java.util.List;

public class SourcesActivity extends BaseActivity<ActivityNewsSourceBinding, SourcesPresenter>
        implements ISources.View, UIListeners.OnSourceClickListener {



    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_news_source;
    }


    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void detachView() {
        presenter.detachView();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.sources);
        getSourcesList();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getSourcesList() {
        presenter.getNewsSources();
    }

    @Override
    public void showList(List<Source> response) {
        RecyclerView recyclerView = binding.rvNewsSources;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        SourcesAdapter adapter = new SourcesAdapter(response,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(Source source) {
        SourcesRouter.goToSourceNewsView(this,source);
    }


}
