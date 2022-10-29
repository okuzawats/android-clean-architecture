package com.okuzawats.cleanarchitecture.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.usecase.getrandomdogimage.GetRandomDogImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  private val getRandomDogImageUseCase: GetRandomDogImageUseCase,
) : ViewModel() {
  fun onEntered() {
    viewModelScope.launch {
      getRandomDogImageUseCase()
        .onEach {
          when (it) {
            is Either.Left -> {
              println("oops! something happen!")
            }
            is Either.Right -> {
              println("dog image = ${it.value.image}")
            }
          }
        }
        .launchIn(this)
    }
  }
}
