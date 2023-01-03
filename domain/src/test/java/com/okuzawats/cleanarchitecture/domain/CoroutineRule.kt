package com.okuzawats.cleanarchitecture.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineRule : TestWatcher() {

  override fun starting(description: Description) {
    Dispatchers.setMain(UnconfinedTestDispatcher())
  }

  override fun finished(description: Description) {
    Dispatchers.resetMain()
  }
}
