package com.dayvatas.artbookkotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.security.MessageDigest

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UserDB", null, 1) {

    // This method is called when the database is created for the first time
    override fun onCreate(db: SQLiteDatabase) {
        // Create a users table
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT)")
    }

    // This method is called when the database version is updated
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db) // Recreate the table
    }

    // Method to insert a user
    fun insertUser(username: String, email: String, password: String): Boolean {
        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("username", username)
            put("email", email)
            put("password", hashPassword(password)) // Hash the password before storing
        }
        val result = database.insert("users", null, contentValues)
        return result != -1L // Returns true if insert was successful
    }

    // Method to check if a user exists
    fun checkUser(username: String, password: String): Boolean {
        val database = this.readableDatabase
        val cursor = database.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", arrayOf(username, hashPassword(password)))
        val userExists = cursor.count > 0
        cursor.close()
        return userExists // Returns true if the user exists
    }

    fun updateArt(id: Int, name: String) {
        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("artname", name)
            // Add other fields if necessary
        }
        database.update("arts", contentValues, "id = ?", arrayOf(id.toString()))
    }


    // Helper method to hash passwords
    private fun hashPassword(password: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val hashBytes = md.digest(password.toByteArray())
        return hashBytes.joinToString("") { String.format("%02x", it) } // Convert byte array to hex string
    }
}