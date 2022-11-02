package com.okuzawats.cleanarchitecture.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.map
import com.okuzawats.cleanarchitecture.presentation.main.MainViewModel
import com.okuzawats.cleanarchitecture.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.states
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject
  internal lateinit var presentationToUiMapper: PresentationToUiMapper

  @Inject
  internal lateinit var uiStateRenderer: UiStateRenderer

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CleanArchitectureTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          viewModel.states
            .map(presentationToUiMapper::toUi)
            .observeAsState()
            .let { uiStateRenderer.RenderAsComposable(it) }
        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    viewModel.onEntered()
  }
}
