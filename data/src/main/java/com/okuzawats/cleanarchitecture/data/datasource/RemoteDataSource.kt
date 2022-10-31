package com.okuzawats.cleanarchitecture.data.datasource

import arrow.core.Either

/**
 * Data source over network
 */
interface RemoteDataSource {
  /**
   * Get random dog image
   */
  suspend fun getRandomDogImage(): Either<Throwable, String>
}
