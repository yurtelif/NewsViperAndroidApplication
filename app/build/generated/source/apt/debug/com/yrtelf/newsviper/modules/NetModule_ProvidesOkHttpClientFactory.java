// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.yrtelf.newsviper.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public final class NetModule_ProvidesOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetModule module;

  private final Provider<Cache> cacheProvider;

  public NetModule_ProvidesOkHttpClientFactory(NetModule module, Provider<Cache> cacheProvider) {
    assert module != null;
    this.module = module;
    assert cacheProvider != null;
    this.cacheProvider = cacheProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.providesOkHttpClient(cacheProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(NetModule module, Provider<Cache> cacheProvider) {
    return new NetModule_ProvidesOkHttpClientFactory(module, cacheProvider);
  }
}
