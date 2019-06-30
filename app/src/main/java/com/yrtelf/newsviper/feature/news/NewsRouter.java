package com.yrtelf.newsviper.feature.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.yrtelf.newsviper.model.News;

public class NewsRouter {

    public static void goToNews(Context context, News news) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(news.getUrl()));
        context.startActivity(i);
    }
}
