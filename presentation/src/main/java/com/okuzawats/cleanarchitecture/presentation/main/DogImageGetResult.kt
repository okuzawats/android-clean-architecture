package com.okuzawats.cleanarchitecture.presentation.main

sealed class DogImageGetResult {
  data class Fetched(val dogImage: String) : DogImageGetResult()
  object FetchFailed : DogImageGetResult()
}
