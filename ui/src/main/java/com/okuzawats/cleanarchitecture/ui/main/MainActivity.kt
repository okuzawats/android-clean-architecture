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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModel
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModelState
import com.okuzawats.cleanarchitecture.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.states

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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
          viewModel.states.observeAsState().value?.let {
            when (it) {
              is MainViewModelState.Initial -> Text(text = "☕")
              is MainViewModelState.Loading -> Text(text = "NOW LOADING...")
              is MainViewModelState.Loaded -> AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                  .data(it.image)
                  .crossfade(true)
                  .build(),
                contentDescription = null,
              )
              is MainViewModelState.LoadFailed -> Text(text = "OOPS...SOMETHING HAPPEN!")
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
