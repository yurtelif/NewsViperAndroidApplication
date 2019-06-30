package com.yrtelf.newsviper.feature.news;

import android.widget.Filter;

import com.yrtelf.newsviper.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsFilter extends Filter {

    NewsAdapter adapter;
    ArrayList<News> filterList;

    public NewsFilter(NewsAdapter adapter, List<News> filterList) {
        this.adapter = adapter;
        this.filterList = new ArrayList<>(filterList);
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<News> filteredPlayers=new ArrayList<>();
            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getTitle().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }
            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.newsList= (ArrayList<News>) results.values;
        adapter.notifyDataSetChanged();
    }


}
