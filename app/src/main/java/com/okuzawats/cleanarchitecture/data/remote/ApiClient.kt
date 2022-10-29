package com.okuzawats.cleanarchitecture.data.remote

import com.okuzawats.cleanarchitecture.data.remote.model.RandomImage
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
  @GET("api/breeds/image/random")
  suspend fun getRandomImage(): Response<RandomImage>
}
