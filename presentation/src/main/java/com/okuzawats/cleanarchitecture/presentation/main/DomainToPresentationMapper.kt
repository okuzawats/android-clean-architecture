package com.okuzawats.cleanarchitecture.presentation.main

import arrow.core.Either
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import javax.inject.Inject

class DomainToPresentationMapper @Inject constructor() {
  fun toPresentation(dogImage: Either<DogImageFetchingException, DogImage>): DogImageGetResult =
    when (dogImage) {
      is Either.Left -> DogImageGetResult.FetchFailed
      is Either.Right -> DogImageGetResult.Fetched(dogImage = dogImage.value.image)
    }
}
