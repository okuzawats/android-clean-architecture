package com.okuzawats.cleanarchitecture.di

import com.okuzawats.cleanarchitecture.navigator.MainNavigatorImpl
import com.okuzawats.cleanarchitecture.ui.MainNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NavigatorModule {
  @Provides
  fun provideMainNavigator(
    impl: MainNavigatorImpl,
  ): MainNavigator = impl
}
