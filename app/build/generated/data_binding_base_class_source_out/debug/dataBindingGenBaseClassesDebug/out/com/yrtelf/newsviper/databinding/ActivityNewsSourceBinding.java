package com.yrtelf.newsviper.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityNewsSourceBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout clActivityMain;

  @NonNull
  public final RecyclerView rvNewsSources;

  protected ActivityNewsSourceBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout clActivityMain, RecyclerView rvNewsSources) {
    super(_bindingComponent, _root, _localFieldCount);
    this.clActivityMain = clActivityMain;
    this.rvNewsSources = rvNewsSources;
  }

  @NonNull
  public static ActivityNewsSourceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_news_source, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityNewsSourceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityNewsSourceBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.activity_news_source, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityNewsSourceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_news_source, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityNewsSourceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityNewsSourceBinding>inflateInternal(inflater, com.yrtelf.newsviper.R.layout.activity_news_source, null, false, component);
  }

  public static ActivityNewsSourceBinding bind(@NonNull View view) {
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
  public static ActivityNewsSourceBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityNewsSourceBinding)bind(component, view, com.yrtelf.newsviper.R.layout.activity_news_source);
  }
}
