package com.yrtelf.newsviper.feature.news;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.yrtelf.newsviper.model.News;

import java.util.List;

public class NewsDiffCallback extends DiffUtil.Callback {

    private final List<News> mOldNewsList;
    private final List<News> mNewsNewsList;

    public NewsDiffCallback(List<News> oldNewsList, List<News> newsNewsList) {
        this.mOldNewsList = oldNewsList;
        this.mNewsNewsList = newsNewsList;
    }

    @Override
    public int getOldListSize() {
        return mOldNewsList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewsNewsList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldNewsList.get(oldItemPosition).getTitle().equals(mNewsNewsList.get(newItemPosition).getTitle());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final News oldNews = mOldNewsList.get(oldItemPosition);
        final News newNews = mNewsNewsList.get(newItemPosition);
        return oldNews.getDescription().equals(newNews.getDescription());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
