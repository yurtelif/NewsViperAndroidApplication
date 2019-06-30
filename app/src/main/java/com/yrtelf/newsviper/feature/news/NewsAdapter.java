package com.yrtelf.newsviper.feature.news;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.yrtelf.newsviper.R;
import com.yrtelf.newsviper.databinding.NewsListItemBinding;
import com.yrtelf.newsviper.model.News;

import com.yrtelf.newsviper.util.UIListeners;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> implements Filterable {

    public List<News> newsList, filterList;
    private UIListeners.OnNewsClickListener listener;
    NewsFilter filter;


    public NewsAdapter(List<News> newsList, UIListeners.OnNewsClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
        this.filterList = newsList;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.news_list_item,
                parent, false);

        NewsHolder holder = new NewsHolder(binding);

        holder.itemView.setOnClickListener(view -> {
            int position = holder.getAdapterPosition();
            News news = newsList.get(position);
            listener.onClick(news);
        });

        holder.binding.button.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            News news = newsList.get(position);
            if(news.isSaved()){
                holder.binding.button.setText(R.string.add_list);
            }else {
                holder.binding.button.setText(R.string.already_in_list);
            }
            listener.onButtonClick(news);
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        News news = newsList.get(position);
        holder.binding.setNews(news);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new NewsFilter(this,filterList);
        }
        return filter;
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {

        private NewsListItemBinding binding;

        public NewsHolder(NewsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public void updateNewsListItem(List<News> newsList){
        final NewsDiffCallback diffCallback = new NewsDiffCallback(this.newsList,newsList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.newsList.clear();
        this.newsList.addAll(newsList);
        diffResult.dispatchUpdatesTo(new ListUpdateCallback() {
            @Override
            public void onInserted(int i, int i1) {

            }

            @Override
            public void onRemoved(int i, int i1) {

            }

            @Override
            public void onMoved(int i, int i1) {

            }

            @Override
            public void onChanged(int i, int i1, @Nullable Object o) {

            }
        });
    }

}

