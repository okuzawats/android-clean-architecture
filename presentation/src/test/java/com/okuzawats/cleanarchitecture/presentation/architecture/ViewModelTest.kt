package com.okuzawats.cleanarchitecture.presentation.architecture

import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

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
      assertEquals(0, awaitItem())
      target.onNewState(42)
      assertEquals(42, awaitItem())
    }
  }

  @Test
  fun doEffect_do_emits() = runTest {
    target.effect.test {
      target.doEffect(0)
      assertEquals(0, awaitItem())
      target.doEffect(42)
      assertEquals(42, awaitItem())
    }
  }
}