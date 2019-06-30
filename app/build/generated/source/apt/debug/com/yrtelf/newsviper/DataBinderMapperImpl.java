package com.yrtelf.newsviper;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.yrtelf.newsviper.databinding.ActivityNewsBindingImpl;
import com.yrtelf.newsviper.databinding.ActivityNewsSourceBindingImpl;
import com.yrtelf.newsviper.databinding.NewsListItemBindingImpl;
import com.yrtelf.newsviper.databinding.NewsSourcesListItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYNEWS = 1;

  private static final int LAYOUT_ACTIVITYNEWSSOURCE = 2;

  private static final int LAYOUT_NEWSLISTITEM = 3;

  private static final int LAYOUT_NEWSSOURCESLISTITEM = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.yrtelf.newsviper.R.layout.activity_news, LAYOUT_ACTIVITYNEWS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.yrtelf.newsviper.R.layout.activity_news_source, LAYOUT_ACTIVITYNEWSSOURCE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.yrtelf.newsviper.R.layout.news_list_item, LAYOUT_NEWSLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.yrtelf.newsviper.R.layout.news_sources_list_item, LAYOUT_NEWSSOURCESLISTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYNEWS: {
          if ("layout/activity_news_0".equals(tag)) {
            return new ActivityNewsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_news is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYNEWSSOURCE: {
          if ("layout/activity_news_source_0".equals(tag)) {
            return new ActivityNewsSourceBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_news_source is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWSLISTITEM: {
          if ("layout/news_list_item_0".equals(tag)) {
            return new NewsListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for news_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWSSOURCESLISTITEM: {
          if ("layout/news_sources_list_item_0".equals(tag)) {
            return new NewsSourcesListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for news_sources_list_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "news");
      sKeys.put(2, "source");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_news_0", com.yrtelf.newsviper.R.layout.activity_news);
      sKeys.put("layout/activity_news_source_0", com.yrtelf.newsviper.R.layout.activity_news_source);
      sKeys.put("layout/news_list_item_0", com.yrtelf.newsviper.R.layout.news_list_item);
      sKeys.put("layout/news_sources_list_item_0", com.yrtelf.newsviper.R.layout.news_sources_list_item);
    }
  }
}
