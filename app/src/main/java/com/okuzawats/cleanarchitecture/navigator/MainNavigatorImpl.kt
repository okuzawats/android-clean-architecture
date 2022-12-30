package com.okuzawats.cleanarchitecture.navigator

import android.app.Activity
import android.content.Intent
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.okuzawats.cleanarchitecture.ui.MainNavigator
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor(
  private val activity: Activity,
): MainNavigator {
  override fun toLicense() {
    activity.startActivity(Intent(activity, OssLicensesMenuActivity::class.java))
  }
}
