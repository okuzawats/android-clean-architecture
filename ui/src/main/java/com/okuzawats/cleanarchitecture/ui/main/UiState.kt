package com.okuzawats.cleanarchitecture.ui.main

sealed class UiState {
  object Initial : UiState()
  object Loading : UiState()
  data class Image(val url: String) : UiState()
  object Error : UiState()
}
