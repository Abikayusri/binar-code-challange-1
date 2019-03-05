package binar.abika.binarcodechallange.feature

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, dbname, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(
            "create table user(id integer primary key autoincrement," +
                    "full_name varchar(30), email varchar(100), university varchar (50), password(20), confirm_password(20)"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertUserData(
        full_name: String,
        email: String,
        university: String,
        password: String,
        confirm_password: String
    ) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("Full Name", full_name)
        values.put("Email", email)
        values.put("University", university)
        values.put("Password", password)
        values.put("Confirm Password", confirm_password)

        db.insert("user", null, values)
        db.close()
    }

    fun userPresent(email: String, password: String): Boolean {
        val db = writableDatabase
        val query = "select * from user where email = '$email' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }
}