package com.yrtelf.newsviper.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.yrtelf.newsviper.model.News;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class NewsListItemBinding extends ViewDataBinding {
  @NonNull
  public final Button button;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @Bindable
  protected News mNews;

  protected NewsListItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button button, ImageView imageView, TextView textView2, TextView textView3) {
    super(_bindingComponent, _root, _localFieldCount);
    this.button = button;
    this.imageView = imageView;
    this.textView2 = textView2;
    this.textView3 = textView3;
  }

  public abstract void setNews(@Nullable News news);

  @Nullable
  public News getNews() {
    return mNews;
  }

  @NonNull
  public static NewsListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.news_list_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static NewsListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<NewsListItemBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.news_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static NewsListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.news_list_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static NewsListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<NewsListItemBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.news_list_item, null, false, component);
  }

  public static NewsListItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static NewsListItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (NewsListItemBinding)bind(component, view, com.yrtelf.newsviper.R.layout.news_list_item);
  }
}
