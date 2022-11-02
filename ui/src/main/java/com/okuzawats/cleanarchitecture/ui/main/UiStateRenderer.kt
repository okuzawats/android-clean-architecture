package com.okuzawats.cleanarchitecture.ui.main

import androidx.compose.runtime.Composable
import javax.inject.Inject

class UiStateRenderer @Inject constructor() {
  @Composable
  fun RenderAsComposable(uiState: UiState) {
    when (uiState) {
      is UiState.Initial -> InitialView()
      is UiState.Loading -> LoadingView()
      is UiState.Image -> ImageView(imageUrl = uiState.url)
      is UiState.Error -> ErrorView()
    }
  }
}
