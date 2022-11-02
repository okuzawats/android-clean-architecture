package com.okuzawats.cleanarchitecture.data.remote.mapper

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.okuzawats.cleanarchitecture.data.remote.model.RandomImage
import retrofit2.Response
import javax.inject.Inject

class DataSourceToDataMapper @Inject constructor() {
  fun toData(
    response: Response<RandomImage>,
  ): Either<Throwable, String> =
    if (response.isSuccessful) {
      checkNotNull(response.body()).message.right()
    } else {
      Throwable("error code received").left()
    }
}
