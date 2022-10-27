package com.okuzawats.cleanarchitecture

import javax.inject.Inject

class HelloWorld @Inject constructor() {
  fun helloWorld(): String = "Hello World"
}
