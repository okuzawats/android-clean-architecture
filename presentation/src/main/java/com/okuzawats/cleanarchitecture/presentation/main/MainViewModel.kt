package com.okuzawats.cleanarchitecture.presentation.main

import androidx.lifecycle.viewModelScope
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val getRandomDogImageUseCase: GetRandomDogImageUseCase,
  private val domainToPresentationMapper: DomainToPresentationMapper,
) : AndroidDataFlow(defaultState = MainViewModelState.Initial) {
  fun onEntered() {
    action {
      setState(MainViewModelState.Loading)
      getRandomDogImageUseCase()
        .map(domainToPresentationMapper::toPresentation)
        .map(MainViewModelState::from)
        .onEach(::setState)
        .launchIn(viewModelScope)
    }
  }
}
