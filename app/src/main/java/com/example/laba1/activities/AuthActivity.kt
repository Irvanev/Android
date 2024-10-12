package com.example.laba1.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.laba1.R
import com.example.laba1.data.User

class AuthActivity : AppCompatActivity() {

    private var registeredUser: User? = null
    private val TAG = "AuthActivity"
    private val REQUEST_CODE_REGISTER = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.d(TAG, "onCreate called")

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.signInButton)
        val notRegisterYet: TextView = findViewById(R.id.registerPromptTextView)

        loginButton.setOnClickListener {
            val login = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, введите логин и пароль", Toast.LENGTH_SHORT).show()
            }
            else if (login == registeredUser?.email && password == registeredUser?.password) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }

        notRegisterYet.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_REGISTER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        if (requestCode == REQUEST_CODE_REGISTER && resultCode == RESULT_OK && data != null) {
            registeredUser = data.getSerializableExtra("user") as? User
            if (registeredUser != null) {
                Toast.makeText(this, "Регистрация прошла успешно!", Toast.LENGTH_SHORT).show()
                emailEditText.setText(registeredUser?.email)
                passwordEditText.setText(registeredUser?.password)
            } else {
                Toast.makeText(this, "Ошибка при получении данных", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}