package com.okuzawats.cleanarchitecture.ui.main

import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelEvent
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelState
import javax.inject.Inject

class PresentationToUiMapper @Inject constructor() {
  fun toUi(presentationState: MainViewModelState): UiState =
    when (presentationState) {
      is MainViewModelState.Initial -> UiState.Initial
      is MainViewModelState.Loading -> UiState.Loading
      is MainViewModelState.Loaded -> UiState.Image(
        url = presentationState.image,
      )
      is MainViewModelState.LoadFailed -> UiState.Error
    }

  fun toUi(presentationEvent: MainViewModelEvent): UiEvent =
    when (presentationEvent) {
      is MainViewModelEvent.NavigateToLicense -> UiEvent.NavigateToLicense
    }
}
