package binar.abika.binarcodechallange.feature

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import binar.abika.binarcodechallange.preferences.AppDataPreferences

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appData = AppDataPreferences(this)
        val isUserLoggedIn = appData.getIsUserLoggedIn()
        if (isUserLoggedIn) {
            routeTo(MainActivity::class.java)
        } else {
            routeTo(DashActivity::class.java)
        }
    }

    private fun routeTo(cls: Class<*>) {
        val intent = Intent(this@SplashScreenActivity, cls)
        startActivity(intent)
        finish()
    }
}

