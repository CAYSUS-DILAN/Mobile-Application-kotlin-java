package com.dayvatas.artbookkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dayvatas.artbookkotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (authenticateUser(username, password)) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                    // Start the main activity or whatever activity after successful login
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login failed. Invalid credentials.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signupRedirectText.setOnClickListener {
            // Redirect to the SignupActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    // Method to authenticate the user using the DatabaseHelper
    private fun authenticateUser(username: String, password: String): Boolean {
        val databaseHelper = DatabaseHelper(this)
        return databaseHelper.checkUser(username, password) // Assuming `checkUser` method validates login credentials
    }
}
