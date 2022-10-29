package com.okuzawats.cleanarchitecture.domain.repository.dogimage

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.repository.dogimage.model.DogImage

/**
 * Repository for dog images
 */
interface DogImageRepository {
  suspend fun getRandom(): Either<DogImageFetchingException, DogImage>
}
