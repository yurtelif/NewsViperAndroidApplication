package com.yrtelf.newsviper.feature.news;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.yrtelf.newsviper.R;
import com.yrtelf.newsviper.base.BaseActivity;
import com.yrtelf.newsviper.databinding.ActivityNewsBinding;
import com.yrtelf.newsviper.model.News;
import com.yrtelf.newsviper.model.Source;
import com.yrtelf.newsviper.util.NewsSharedPreferences;
import com.yrtelf.newsviper.util.NewsUtils;
import com.yrtelf.newsviper.util.UIListeners;

import java.util.ArrayList;
import java.util.List;

import static com.yrtelf.newsviper.util.AppKeys.KEY_SOURCE;

public class NewsActivity extends BaseActivity<ActivityNewsBinding, NewsPresenter> implements INews.View, UIListeners.OnNewsClickListener, SearchView.OnQueryTextListener {

    private Handler handler = new Handler();
    private Runnable runnableCode;
    private NewsAdapter adapter;
    private int count = 0;

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        Source source = bundle.getParcelable(KEY_SOURCE);
        getSupportActionBar().setTitle(source.getName());
        runnableCode = new Runnable() {
            @Override
            public void run() {
                getNewsList(source.getId());
                handler.postDelayed(this, 60000);
            }
        };
        handler.post(runnableCode);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                NewsActivity.super.closeKeyboard();
                return true;
            }
        });

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectDagger() {
        getAppComponent().inject(this);
    }

    @Override
    protected int getXmlLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void attachView() {
        presenter.attachView(this);
    }

    @Override
    protected void detachView() {
        presenter.detachView();
        handler.removeCallbacks(runnableCode);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<News> response) {
        if(count == 0){
            RecyclerView recyclerView = binding.rvNews;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            adapter = new NewsAdapter(NewsUtils.checkNewsFromSP(new ArrayList<>(response)),this);
            recyclerView.setAdapter(adapter);
        }
        else {
            adapter.updateNewsListItem(response);
        }
    }

    @Override
    public void getNewsList(String sourceId) {
        presenter.getNews(sourceId);
    }

    @Override
    public void onClick(News news) {
        NewsRouter.goToNews(this,news);
    }

    @Override
    public void onButtonClick(News news) {
        ArrayList<News> newsList = NewsSharedPreferences.getInstance().getNews();
        if(news.isSaved()){
            newsList.remove(news);
            for (News newsSp : newsList) {
                if(news.getTitle().equals(newsSp.getTitle())){
                    newsList.remove(newsSp);
                }
            }
            NewsSharedPreferences.getInstance().setNews(newsList);
        }else {
            if(newsList == null){
                ArrayList<News> arrayList = new ArrayList<>();
                arrayList.add(news);
                NewsSharedPreferences.getInstance().setNews(arrayList);
            }else{
                newsList.add(news);
                NewsSharedPreferences.getInstance().setNews(newsList);
                news.setSaved(true);
            }

        }
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }
}
