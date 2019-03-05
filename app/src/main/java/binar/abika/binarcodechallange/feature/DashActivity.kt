package binar.abika.binarcodechallange.feature

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import binar.abika.binarcodechallange.R
import kotlinx.android.synthetic.main.activity_dash.*

class DashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)

        setupListener()
    }


    private fun setupListener() {
        btn_dash_login.setOnClickListener {
            login()
        }
        btn_dash_register.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val intent = Intent(this@DashActivity, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun login() {
        val intent = Intent(this@DashActivity, LoginActivity::class.java)
        startActivity(intent)
    }
}
