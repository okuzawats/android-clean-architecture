package com.okuzawats.cleanarchitecture.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImageView(imageUrl: String) = AsyncImage(
  model = ImageRequest.Builder(LocalContext.current)
    .data(imageUrl)
    .crossfade(true)
    .build(),
  contentDescription = null,
)
