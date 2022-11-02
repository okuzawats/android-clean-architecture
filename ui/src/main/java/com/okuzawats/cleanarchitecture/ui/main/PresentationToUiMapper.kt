package com.okuzawats.cleanarchitecture.ui.main

import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelState
import io.uniflow.core.flow.data.UIState
import javax.inject.Inject

class PresentationToUiMapper @Inject constructor() {
  fun toUi(presentationState: UIState): UiState =
    when (presentationState as MainViewModelState) {
      is MainViewModelState.Initial -> UiState.Initial
      is MainViewModelState.Loading -> UiState.Loading
      is MainViewModelState.Loaded -> UiState.Image(
        url = (presentationState as MainViewModelState.Loaded).image,
      )
      is MainViewModelState.LoadFailed -> UiState.Error
    }
}
