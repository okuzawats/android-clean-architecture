package com.okuzawats.cleanarchitecture.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.map
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModel
import com.okuzawats.cleanarchitecture.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.states
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  internal lateinit var presentationToUiMapper: PresentationToUiMapper

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CleanArchitectureTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          viewModel.states
            .map(presentationToUiMapper::toUi)
            .observeAsState().value?.let {
              when (it) {
                is UiState.Initial -> Text(text = "☕")
                is UiState.Loading -> Text(text = "NOW LOADING...")
                is UiState.Image -> AsyncImage(
                  model = ImageRequest.Builder(LocalContext.current)
                    .data(it.url)
                    .crossfade(true)
                    .build(),
                  contentDescription = null,
                )
                is UiState.Error -> Text(text = "OOPS...SOMETHING HAPPEN!")
              }
            }
        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    viewModel.onEntered()
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  CleanArchitectureTheme {
    Text(text = "Hello World")
  }
}
