package com.okuzawats.cleanarchitecture.data.mapper.dogimage

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import javax.inject.Inject

class DataToDomainMapper @Inject constructor() {
  fun toDomain(
    dogImage: Either<Throwable, String>,
  ): Either<DogImageFetchingException, DogImage> =
    dogImage.map {
      DogImage(image = it)
    }.mapLeft {
      DogImageFetchingException("oops, failed to fetch!")
    }
}
