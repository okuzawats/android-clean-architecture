package com.okuzawats.cleanarchitecture.ui.main

import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelEvent
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelState
import io.uniflow.core.flow.data.UIEvent
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

  fun toUi(presentationEvent: UIEvent): UiEvent =
    when (presentationEvent as MainViewModelEvent) {
      is MainViewModelEvent.NavigateToLicense -> UiEvent.NavigateToLicense
    }
}
