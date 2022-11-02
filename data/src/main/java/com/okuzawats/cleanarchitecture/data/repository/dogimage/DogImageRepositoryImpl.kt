package com.okuzawats.cleanarchitecture.data.repository.dogimage

import arrow.core.Either
import com.okuzawats.cleanarchitecture.data.datasource.RemoteDataSource
import com.okuzawats.cleanarchitecture.data.mapper.dogimage.DataToDomainMapper
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.model.DogImage
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.repository.DogImageRepository
import com.okuzawats.cleanarchitecture.domain.getrandomdogimage.exception.DogImageFetchingException
import javax.inject.Inject

/**
 * Implementation of [DogImageRepository]
 */
class DogImageRepositoryImpl @Inject constructor(
  private val remoteDataSource: RemoteDataSource,
  private val dataToDomainMapper: DataToDomainMapper,
) : DogImageRepository {
  override suspend fun getRandom(): Either<DogImageFetchingException, DogImage> =
    dataToDomainMapper.toDomain(
      dogImage = remoteDataSource.getRandomDogImage(),
    )
}
