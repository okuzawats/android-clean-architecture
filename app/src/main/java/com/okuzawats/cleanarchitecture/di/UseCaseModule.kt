package com.okuzawats.cleanarchitecture.di

import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.impl.GetRandomDogImageUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
  @Provides
  fun provideGetRandomDogImageUseCase(
    impl: GetRandomDogImageUseCaseImpl,
  ): GetRandomDogImageUseCase = impl
}
