package binar.abika.binarcodechallange.feature

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.abika.binarcodechallange.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUp()
    }

    private fun setUp() {
        btn_register_register.setOnClickListener {
            val fullName = et_register_full_name.text.toString() // ini dari id layout register
            val addressEmail = et_register_email.text.toString()
            val university = et_register_university.text.toString()
            val pass1 = et_register_password.text.toString()
            val pass2 = et_register_confirm_password.text.toString()

            if (pass1 == pass2){
                register(fullName,addressEmail,university,pass1,pass2)
            }
            else{
                Toast.makeText(this,"Register Failed, Please Check Your Text",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun register(
        fullName: String,
        addressEmail: String,
        university: String,
        pass1: String,
        pass2: String
    ) {
        val myRfer = getSharedPreferences("myRfer", Context.MODE_PRIVATE)
        val editor = myRfer.edit()
        editor.putString("Name",fullName)
        editor.putString("Email",addressEmail)
        editor.putString("University",university)
        editor.putString("Password",pass1)
        editor.putString("Confirm_Password",pass2)

        editor.apply()

        Toast.makeText(this,"Save Register",Toast.LENGTH_SHORT).show()
        val intent = Intent(this@RegisterActivity,MainActivity::class.java)
        startActivity(intent)
    }
}