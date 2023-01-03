package com.okuzawats.cleanarchitecture.presentation.architecture

import androidx.lifecycle.viewModelScope
import arrow.core.valid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * a subclass of [androidx.lifecycle.ViewModel] which has state and effect.
 *
 * @param STATE type that represent the state of the ViewModel.
 * @param EFFECT type that represent the effect the ViewModel has.
 */
abstract class ViewModel<STATE: Any, EFFECT: Any> : androidx.lifecycle.ViewModel() {
  private val _state: MutableStateFlow<STATE> by lazy {
    MutableStateFlow(initialState())
  }

  /**
   * state of the ViewModel.
   */
  val state: Flow<STATE> get() = _state.asStateFlow()

  private val _effect: MutableSharedFlow<EFFECT> by lazy {
    MutableSharedFlow<EFFECT>()
  }

  /**
   * effect that the ViewModel has.
   */
  val effect: Flow<EFFECT> get() = _effect.asSharedFlow()

  /**
   * initial state of the ViewModel.
   */
  abstract fun initialState(): STATE

  /**
   *
   */
  internal suspend fun onNewState(state: STATE) {
    _state.emit(state)
  }

  /**
   *
   */
  internal suspend fun doEffect(effect: EFFECT) {
    _effect.emit(effect)
  }
}
