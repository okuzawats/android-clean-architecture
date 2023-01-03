package com.okuzawats.cleanarchitecture.presentation.architecture

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelTest {

  private lateinit var target: ViewModel<Int, Int>

  @Before
  fun setUp() {
    target = object : ViewModel<Int, Int>() {
      override fun initialState(): Int = 0
    }
  }

  @After
  fun tearDown() {
  }

  @Test
  fun onNewState_update_state() = runTest {
    target.state.test {
      target.onNewState(0)

      assertThat(awaitItem())
        .isEqualTo(0)

      target.onNewState(42)

      assertThat(awaitItem())
        .isEqualTo(42)
    }
  }

  @Test
  fun doEffect_do_emits() = runTest {
    target.effect.test {
      target.doEffect(0)

      assertThat(awaitItem())
        .isEqualTo(0)

      target.doEffect(42)

      assertThat(awaitItem())
        .isEqualTo(42)
    }
  }
}
