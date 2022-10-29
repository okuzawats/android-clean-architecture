package com.okuzawats.cleanarchitecture.domain.usecase.getrandomdogimage.impl

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.repository.dogimage.DogImageRepository
import com.okuzawats.cleanarchitecture.domain.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.repository.dogimage.model.DogImage
import com.okuzawats.cleanarchitecture.domain.usecase.getrandomdogimage.GetRandomDogImageUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Implementation of [GetRandomDogImageUseCase]
 */
class GetRandomDogImageUseCaseImpl @Inject constructor(
  private val dogImageRepository: DogImageRepository,
) : GetRandomDogImageUseCase {
  override suspend fun invoke(): Flow<Either<DogImageFetchingException, DogImage>> =
    flow {
      emit(dogImageRepository.getRandom())
    }
}
