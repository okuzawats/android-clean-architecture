package com.okuzawats.cleanarchitecture.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

private const val API_END_POINT = "https://dog.ceo/"

/**
 * Provide [ApiClient]
 */
class ApiClientProvider @Inject constructor() {
  /**
   * Create and provide [ApiClient]
   *
   * @return [ApiClient]
   */
  @ExperimentalSerializationApi
  fun provide(): ApiClient =
    Retrofit.Builder()
      .baseUrl(API_END_POINT)
      .addConverterFactory(
        Json.asConverterFactory(
          "application/json".toMediaType(),
        ),
      )
      .build()
      .create(ApiClient::class.java)
}
