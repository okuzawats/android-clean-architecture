package com.okuzawats.cleanarchitecture.domain.getrandomdogimage

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.dogimage.model.DogImage
import kotlinx.coroutines.flow.Flow

/**
 * A use case of getting a random dog image
 */
interface GetRandomDogImageUseCase {
  suspend operator fun invoke(): Flow<Either<DogImageFetchingException, DogImage>>
}
