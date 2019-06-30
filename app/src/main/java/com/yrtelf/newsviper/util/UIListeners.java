package com.yrtelf.newsviper.util;

import com.yrtelf.newsviper.model.News;
import com.yrtelf.newsviper.model.Source;

public interface UIListeners {

    interface OnSourceClickListener {
        void onClick(Source source);
    }

    interface OnNewsClickListener {
        void onClick(News news);
        void onButtonClick(News news);
    }

}
