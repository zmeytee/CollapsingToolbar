package ru.zmeytee.myapplication

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }

        val isNightMode = resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        setSystemUiVisibilityFlag(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR, !isNightMode)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, ToolbarFragment::class.java, null)
            .commit()
    }

}

@Suppress("DEPRECATION")
private fun Activity.setSystemUiVisibilityFlag(bits: Int, on: Boolean) {
    var flags: Int = window.decorView.systemUiVisibility // get current flag
    flags = if (on) {
        flags or bits
    } else {
        flags and bits.inv()
    }
    window.decorView.systemUiVisibility = flags
}