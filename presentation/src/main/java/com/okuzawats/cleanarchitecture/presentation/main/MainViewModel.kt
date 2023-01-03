package com.okuzawats.cleanarchitecture.presentation.main

import androidx.lifecycle.viewModelScope
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import com.okuzawats.cleanarchitecture.presentation.architecture.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val getRandomDogImageUseCase: GetRandomDogImageUseCase,
  private val domainToPresentationMapper: DomainToPresentationMapper,
) : ViewModel<MainViewModelState, MainViewModelEvent>() {
  fun onEntered() {
    viewModelScope.launch {
      onNewState(MainViewModelState.Loading)
      getRandomDogImageUseCase()
        .map(domainToPresentationMapper::toPresentation)
        .map(MainViewModelState::from)
        .onEach(::onNewState)
        .launchIn(this)
    }
  }

  fun onLicenseAction() {
    viewModelScope.launch {
      doEffect(MainViewModelEvent.NavigateToLicense)
    }
  }

  override fun initialState(): MainViewModelState = MainViewModelState.initial()
}
