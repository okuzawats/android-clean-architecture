package com.okuzawats.cleanarchitecture.presentation.main

import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val getRandomDogImageUseCase: GetRandomDogImageUseCase,
) : AndroidDataFlow(defaultState = MainViewModelState.Initial) {
  fun onEntered() {
    action {
      setState(MainViewModelState.Loading)
      getRandomDogImageUseCase()
        .onEach {
          when (it) {
            is Either.Left -> {
              setState(MainViewModelState.LoadFailed)
            }
            is Either.Right -> {
              setState(
                MainViewModelState.Loaded(
                  image = it.value.image
                )
              )
            }
          }
        }
        .launchIn(viewModelScope)
    }
  }
}
