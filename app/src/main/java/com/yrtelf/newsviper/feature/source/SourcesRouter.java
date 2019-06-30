package com.yrtelf.newsviper.feature.source;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yrtelf.newsviper.feature.news.NewsActivity;
import com.yrtelf.newsviper.model.Source;

import static com.yrtelf.newsviper.util.AppKeys.KEY_SOURCE;

public class SourcesRouter {

    public static void goToSourceNewsView(Context context, Source source) {
        Intent intent = new Intent(context, NewsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SOURCE,source);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

}
