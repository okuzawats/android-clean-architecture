package com.okuzawats.cleanarchitecture.di

import com.okuzawats.cleanarchitecture.data.remote.ApiClient
import com.okuzawats.cleanarchitecture.data.remote.ApiClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {
  @ExperimentalSerializationApi
  @Provides
  fun provideApiClient(
    apiClientProvider: ApiClientProvider,
  ): ApiClient = apiClientProvider.provide()
}
