package binar.abika.binarcodechallange.feature

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import binar.abika.binarcodechallange.R
import binar.abika.binarcodechallange.preferences.AppDataPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var androidAdapter: AndroidAdapter
    private lateinit var appData: AppDataPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupComponent()
        addDummyData()
    }

    private fun setupComponent() {
        appData = AppDataPreferences(this)
        androidAdapter = AndroidAdapter()

        rv_main_android.setHasFixedSize(true)
        rv_main_android.layoutManager = LinearLayoutManager(this)
        rv_main_android.adapter = androidAdapter
    }


    private fun addDummyData() {
        val androidList = mutableListOf<Android>()
        androidList.add(Android("Pie", "Android 9", "API Level 28"))
        androidList.add(Android("Oreo", "Android 8.1", "API Level 27"))
        androidList.add(Android("Oreo", "Android 8.0", "API Level 26"))
        androidList.add(Android("Nougat", "Android 7.1", "API Level 25"))
        androidList.add(Android("Nougat", "Android 7.0", "API Level 24"))
        androidList.add(Android("Marshmallow", "Android 6.0", "API Level 23"))
        androidList.add(Android("Lollipop", "Android 5.1", "API Level 22"))

        androidAdapter.addAndroidList(androidList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId){
            R.id.option_settings -> {
                appData.cleanUserData()
                startActivity(Intent(this@MainActivity, DashActivity::class.java))
                finish()
                Toast.makeText(this, "Logout Success", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}