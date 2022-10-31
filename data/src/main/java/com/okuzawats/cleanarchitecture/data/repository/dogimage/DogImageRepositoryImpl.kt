package com.okuzawats.cleanarchitecture.data.repository.dogimage

import arrow.core.Either
import com.okuzawats.cleanarchitecture.data.datasource.RemoteDataSource
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.repository.DogImageRepository
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import javax.inject.Inject

/**
 * Implementation of [DogImageRepository]
 */
class DogImageRepositoryImpl @Inject constructor(
  private val remoteDataSource: RemoteDataSource,
) : DogImageRepository {
  override suspend fun getRandom(): Either<DogImageFetchingException, DogImage> =
    remoteDataSource.getRandomDogImage()
      .map {
        DogImage(image = it)
      }.mapLeft {
        DogImageFetchingException("oops, failed to fetch!")
      }
}
