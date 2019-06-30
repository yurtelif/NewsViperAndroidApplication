package com.yrtelf.newsviper.feature.source;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yrtelf.newsviper.R;
import com.yrtelf.newsviper.databinding.NewsSourcesListItemBinding;
import com.yrtelf.newsviper.model.Source;
import com.yrtelf.newsviper.util.UIListeners;

import java.util.List;

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.NewsSourceHolder> {

    private List<Source> sourceList;
    private UIListeners.OnSourceClickListener listener;

    public SourcesAdapter(List<Source> sourceList, UIListeners.OnSourceClickListener listener) {
        this.sourceList = sourceList;
        this.listener = listener;
    }

    @Override
    public NewsSourceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsSourcesListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.news_sources_list_item,
                parent, false);

        NewsSourceHolder holder = new NewsSourceHolder(binding);
        holder.itemView.setOnClickListener(view -> {
            int position = holder.getAdapterPosition();
            Source source = sourceList.get(position);
            listener.onClick(source);
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(NewsSourceHolder holder, int position) {
        Source source = sourceList.get(position);
        holder.binding.setSource(source);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }

    public static class NewsSourceHolder extends RecyclerView.ViewHolder {

        private NewsSourcesListItemBinding binding;

        public NewsSourceHolder(NewsSourcesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}

