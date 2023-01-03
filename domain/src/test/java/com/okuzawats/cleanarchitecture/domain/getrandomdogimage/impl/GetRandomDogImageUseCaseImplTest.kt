package com.okuzawats.cleanarchitecture.domain.getrandomdogimage.impl

import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.okuzawats.cleanarchitecture.domain.CoroutineRule
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.GetRandomDogImageUseCase
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.repository.DogImageRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetRandomDogImageUseCaseImplTest {

  @get:Rule
  val coroutineRule = CoroutineRule()

  private lateinit var dogImageRepository: DogImageRepository

  private lateinit var target: GetRandomDogImageUseCase

  @Before
  fun setUp() {
    dogImageRepository = mockk()
    target = GetRandomDogImageUseCaseImpl(
      dogImageRepository = dogImageRepository,
    )
  }

  @After
  fun tearDown() {
  }

  @Test
  fun execution_emits_what_repository_returns() = runTest {
    coEvery { dogImageRepository.getRandom() } returns
        Either.Right(DogImage("I am an image of a dog!"))

    target().test {
      val emitted = awaitItem()
      assertThat((emitted as Either.Right).value.image)
        .isEqualTo("I am an image of a dog!")
      awaitComplete()
    }
  }
}
