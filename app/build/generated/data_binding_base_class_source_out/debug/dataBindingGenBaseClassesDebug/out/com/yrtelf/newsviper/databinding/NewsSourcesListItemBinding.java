package com.yrtelf.newsviper.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yrtelf.newsviper.model.Source;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class NewsSourcesListItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @Bindable
  protected Source mSource;

  protected NewsSourcesListItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView textView, TextView textView2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.textView = textView;
    this.textView2 = textView2;
  }

  public abstract void setSource(@Nullable Source source);

  @Nullable
  public Source getSource() {
    return mSource;
  }

  @NonNull
  public static NewsSourcesListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.news_sources_list_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static NewsSourcesListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<NewsSourcesListItemBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.news_sources_list_item, root, attachToRoot, component);
  }

  @NonNull
  public static NewsSourcesListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.news_sources_list_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static NewsSourcesListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<NewsSourcesListItemBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.news_sources_list_item, null, false, component);
  }

  public static NewsSourcesListItemBinding bind(@NonNull View view) {
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
  public static NewsSourcesListItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (NewsSourcesListItemBinding)bind(component, view, com.yrtelf.newsviper.R.layout.news_sources_list_item);
  }
}
