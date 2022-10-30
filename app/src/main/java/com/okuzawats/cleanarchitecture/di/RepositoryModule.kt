package com.okuzawats.cleanarchitecture.di

import com.okuzawats.cleanarchitecture.data.repository.dogimage.DogImageRepositoryImpl
import com.okuzawats.cleanarchitecture.domain.dogimage.DogImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
  @Provides
  fun provideDogImageRepository(
    impl: DogImageRepositoryImpl,
  ): DogImageRepository = impl
}
