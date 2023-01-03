package com.okuzawats.cleanarchitecture.presentation.main

sealed class MainViewModelEvent {
  object NavigateToLicense : MainViewModelEvent()
}
