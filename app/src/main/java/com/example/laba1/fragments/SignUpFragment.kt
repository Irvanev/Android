package com.example.laba1.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.laba1.R
import com.example.laba1.activities.MainActivity
import com.example.laba1.data.User
import org.jetbrains.annotations.Nullable


class SignUpFragment : Fragment() {

    private val TAG = "RegisterFragment"

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.activity_register, container, false)

        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
        val emailEditText = view.findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val registerButton = view.findViewById<Button>(R.id.signInButton)
        val loginPromptTextView = view.findViewById<TextView>(R.id.loginPromptTextView)

        registerButton.setOnClickListener { v: View? ->
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(name, email, password)
                (activity as MainActivity).navigateToAuth(user)
            } else {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        loginPromptTextView.setOnClickListener { v: View? ->
            (activity as MainActivity).navigateToAuth(null)
        }

        return view
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