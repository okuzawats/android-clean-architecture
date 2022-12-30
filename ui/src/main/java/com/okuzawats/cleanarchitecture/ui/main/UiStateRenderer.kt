package com.okuzawats.cleanarchitecture.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import javax.inject.Inject

class UiStateRenderer @Inject constructor() {
  @Composable
  fun RenderAsComposable(
    uiState: State<UiState?>,
    onLicenseClicked: () -> Unit,
  ) {
    when (uiState.value) {
      is UiState.Initial -> InitialView()
      is UiState.Loading -> LoadingView()
      is UiState.Image -> {
        Column {
          Button(onClick = onLicenseClicked) {
            Text(text = "LICENSE")
          }
          ImageView(
            imageUrl = (uiState.value as UiState.Image).url,
          )
        }
      }
      is UiState.Error -> ErrorView()
      else -> Unit
    }
  }
}
