package com.okuzawats.cleanarchitecture.presentation.main

/**
 * Express state of [MainViewModel]
 */
sealed class MainViewModelState {
  companion object {
    fun initial(): MainViewModelState = Initial

    fun from(result: DogImageGetResult): MainViewModelState =
      when (result) {
        is DogImageGetResult.FetchFailed -> LoadFailed
        is DogImageGetResult.Fetched -> Loaded(
          image = result.dogImage
        )
      }
  }

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
