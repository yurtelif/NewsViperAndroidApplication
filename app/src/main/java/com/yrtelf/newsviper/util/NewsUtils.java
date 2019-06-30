package com.yrtelf.newsviper.util;

import com.yrtelf.newsviper.model.News;

import java.util.ArrayList;

public class NewsUtils {

    public static ArrayList<News> checkNewsFromSP(ArrayList<News> newsArrayList){
        ArrayList<News> arrayList = NewsSharedPreferences.getInstance().getNews();
        if(arrayList != null){
            for (News news : arrayList) {
                for (News newsItem : newsArrayList) {
                    if(news.getTitle().equals(newsItem.getTitle())){
                        newsItem.setSaved(true);
                    }
                }

            }
        }
        return newsArrayList;
    }



}
