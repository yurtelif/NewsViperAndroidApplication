// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.yrtelf.newsviper.feature.source;

import dagger.MembersInjector;
import javax.inject.Provider;

public final class SourcesActivity_MembersInjector implements MembersInjector<SourcesActivity> {
  private final Provider<SourcesPresenter> presenterProvider;

  public SourcesActivity_MembersInjector(Provider<SourcesPresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<SourcesActivity> create(
      Provider<SourcesPresenter> presenterProvider) {
    return new SourcesActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(SourcesActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.yrtelf.newsviper.base.BaseActivity_MembersInjector.injectPresenter(
        instance, presenterProvider);
  }
}