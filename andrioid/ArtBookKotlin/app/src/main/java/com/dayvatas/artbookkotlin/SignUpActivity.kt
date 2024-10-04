package com.dayvatas.artbookkotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dayvatas.artbookkotlin.databinding.ActivitySgnupactivityBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySgnupactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySgnupactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    if (saveUser(username, email, password)) {
                        Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                        finish() // Close signup activity
                    } else {
                        Toast.makeText(this, "Signup failed. Please try again.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Method to handle back button click
    fun onBackButtonClicked(view: View) {
        finish() // Close the current activity
    }

    // Method to save the user using the DatabaseHelper
    private fun saveUser(username: String, email: String, password: String): Boolean {
        val databaseHelper = DatabaseHelper(this)
        return databaseHelper.insertUser(username, email, password) // Call the insertUser method from DatabaseHelper
    }
}
