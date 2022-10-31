package com.okuzawats.cleanarchitecture.data.remote

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.okuzawats.cleanarchitecture.data.datasource.RemoteDataSource
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
  private val apiClient: ApiClient,
) : RemoteDataSource {
  // TODO: define error types
  override suspend fun getRandomDogImage(): Either<Throwable, String> =
    try {
      val response = apiClient.getRandomImage()
      if (response.isSuccessful) {
        checkNotNull(response.body()).message.right()
      } else {
        Throwable("error code received").left()
      }
    } catch (e: IOException) {
      Throwable("response not received").left()
    }
}