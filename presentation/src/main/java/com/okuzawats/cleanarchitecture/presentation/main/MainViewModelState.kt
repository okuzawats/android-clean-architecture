package com.okuzawats.cleanarchitecture.presentation.main

import io.uniflow.core.flow.data.UIState

/**
 * Express state of [MainViewModel]
 */
sealed class MainViewModelState : UIState() {
  /**
   * Initial state
   */
  object Initial : MainViewModelState()

  /**
   * Loading state
   */
  object Loading : MainViewModelState()

  /**
   * Loaded State
   *
   * @property image express image
   */
  data class Loaded(val image: String) : MainViewModelState()

  /**
   * Load failed state
   */
  object LoadFailed : MainViewModelState()
}
