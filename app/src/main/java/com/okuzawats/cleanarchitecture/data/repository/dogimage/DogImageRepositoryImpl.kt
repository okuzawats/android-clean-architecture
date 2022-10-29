package com.okuzawats.cleanarchitecture.data.repository.dogimage

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.okuzawats.cleanarchitecture.data.remote.ApiClient
import com.okuzawats.cleanarchitecture.domain.repository.dogimage.model.DogImage
import com.okuzawats.cleanarchitecture.domain.repository.dogimage.DogImageRepository
import com.okuzawats.cleanarchitecture.domain.exception.DogImageFetchingException
import java.io.IOException
import javax.inject.Inject

/**
 * Implementation of [DogImageRepository]
 */
class DogImageRepositoryImpl @Inject constructor(
  private val apiClient: ApiClient,
): DogImageRepository {
  override suspend fun getRandom(): Either<DogImageFetchingException, DogImage> =
    try {
      val response = apiClient.getRandomImage()
      if (response.isSuccessful) {
        DogImage(checkNotNull(response.body()).message).right()
      } else {
        DogImageFetchingException("error code received").left()
      }
    } catch (e: IOException) {
      DogImageFetchingException("response not received").left()
    }
  }
