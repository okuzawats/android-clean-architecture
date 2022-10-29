package com.okuzawats.cleanarchitecture.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * API model of random image
 */
@Serializable
data class RandomImage(
  @SerialName("message") val message: String,
  @SerialName("status") val status: String,
)
