package com.okuzawats.cleanarchitecture.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import javax.inject.Inject

class UiStateRenderer @Inject constructor() {
  @Composable
  fun RenderAsComposable(uiState: State<UiState?>) {
    when (uiState.value) {
      is UiState.Initial -> InitialView()
      is UiState.Loading -> LoadingView()
      is UiState.Image -> ImageView(
        imageUrl = (uiState.value as UiState.Image).url,
      )
      is UiState.Error -> ErrorView()
      else -> Unit
    }
  }
}
