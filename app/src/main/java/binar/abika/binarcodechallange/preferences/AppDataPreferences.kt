package binar.abika.binarcodechallange.preferences

import android.content.Context
import android.content.SharedPreferences
import binar.abika.binarcodechallange.R
import binar.abika.binarcodechallange.config.Config

class AppDataPreferences(private val context: Context) {

    companion object {
        private var preferences: SharedPreferences? = null

        fun getSharedPref(context: Context): SharedPreferences = preferences ?: synchronized(this) {
            getPreferences(context).also {
                preferences = it
            }
        }

        private fun getPreferences(context: Context) =
            context.getSharedPreferences(context.getString(R.string.key_app_data), Context.MODE_PRIVATE)
    }

    fun cleanUserData() {
        getSharedPref(context).edit().clear().apply()
    }

    fun putIsUserLoggedIn(isLoggedIn: Boolean) {
        with(getSharedPref(context).edit()) {
            putBoolean(Config.IS_USER_LOGGED_IN_PREF, isLoggedIn)
            apply()
        }
    }

    fun getIsUserLoggedIn(): Boolean {
        return getSharedPref(context).getBoolean(Config.IS_USER_LOGGED_IN_PREF, false)
    }
}