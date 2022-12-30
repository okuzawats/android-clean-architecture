package com.okuzawats.cleanarchitecture.presentation.main

import io.uniflow.core.flow.data.UIEvent

sealed class MainViewModelEvent : UIEvent(){
  object NavigateToLicense : MainViewModelEvent()
}
