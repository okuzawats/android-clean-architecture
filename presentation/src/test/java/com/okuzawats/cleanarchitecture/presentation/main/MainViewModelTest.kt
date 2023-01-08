package com.okuzawats.cleanarchitecture.presentation.main

import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import com.okuzawats.cleanarchitecture.test.CoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

  @get:Rule
  val coroutineRule = CoroutineRule()

  private lateinit var getRandomDogImageUseCase: GetRandomDogImageUseCase
  private lateinit var domainToPresentationMapper: DomainToPresentationMapper

  private lateinit var target: MainViewModel

  @Before
  fun setUp() {
    getRandomDogImageUseCase = mockk()
    domainToPresentationMapper = DomainToPresentationMapper()
    target = MainViewModel(
      getRandomDogImageUseCase = getRandomDogImageUseCase,
      domainToPresentationMapper = domainToPresentationMapper,
    )
  }

  @After
  fun tearDown() {
  }

  @Test
  fun onEntered_emits_initial_first() = runTest {
    coEvery { getRandomDogImageUseCase() } returns flow {
      emit(Either.Right(DogImage("I am a dog image!")))
    }

    target.state.test {
      target.onEntered()

      assertThat(awaitItem())
        .isInstanceOf(MainViewModelState.Initial::class.java)
      awaitItem()
      awaitItem()
    }
  }

  @Test
  fun onEntered_emits_loading_second() = runTest {
    coEvery { getRandomDogImageUseCase() } returns flow {
      emit(Either.Right(DogImage("I am a dog image!")))
    }

    target.state.test {
      target.onEntered()

      awaitItem()
      assertThat(awaitItem())
        .isInstanceOf(MainViewModelState.Loading::class.java)
      awaitItem()
    }
  }

  @Test
  fun onEntered_emits_loaded_finally() = runTest {
    coEvery { getRandomDogImageUseCase() } returns flow {
      emit(Either.Right(DogImage("I am a dog image!")))
    }

    target.state.test {
      target.onEntered()

      awaitItem()
      awaitItem()
      assertThat(awaitItem())
        .isInstanceOf(MainViewModelState.Loaded::class.java)
    }
  }

  @Test
  fun onEntered_emits_load_failed_if_has_error() = runTest {
    coEvery { getRandomDogImageUseCase() } returns flow {
      emit(Either.Left(DogImageFetchingException("something wrong!")))
    }

    target.state.test {
      target.onEntered()

      awaitItem()
      awaitItem()
      assertThat(awaitItem())
        .isInstanceOf(MainViewModelState.LoadFailed::class.java)
    }
  }

  @Test
  fun onLicenseAction_emits_NavigateToLicense_event() = runTest {
    target.effect.test {
      target.onLicenseAction()

      assertThat(awaitItem())
        .isInstanceOf(MainViewModelEvent.NavigateToLicense::class.java)
    }
  }
}