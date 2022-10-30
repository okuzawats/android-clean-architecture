package com.okuzawats.cleanarchitecture.domain.getrandomdogimage.repository

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage

/**
 * Repository for dog images
 */
interface DogImageRepository {
  suspend fun getRandom(): Either<DogImageFetchingException, DogImage>
}
