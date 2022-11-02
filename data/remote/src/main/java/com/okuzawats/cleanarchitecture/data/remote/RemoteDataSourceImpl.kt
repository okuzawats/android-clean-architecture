package com.okuzawats.cleanarchitecture.data.remote

import arrow.core.Either
import arrow.core.left
import com.okuzawats.cleanarchitecture.data.datasource.RemoteDataSource
import com.okuzawats.cleanarchitecture.data.remote.mapper.DataSourceToDataMapper
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
  private val apiClient: ApiClient,
  private val dataSourceToDataMapper: DataSourceToDataMapper,
) : RemoteDataSource {
  // TODO: define error types
  override suspend fun getRandomDogImage(): Either<Throwable, String> =
    try {
      dataSourceToDataMapper.toData(
        apiClient.getRandomImage()
      )
    } catch (e: IOException) {
      Throwable("response not received").left()
    }
}
