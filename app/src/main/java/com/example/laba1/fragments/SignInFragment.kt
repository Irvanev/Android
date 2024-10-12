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
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.example.laba1.R
import com.example.laba1.activities.MainActivity
import com.example.laba1.data.User
import org.jetbrains.annotations.Nullable

class SignInFragment : Fragment() {
    private var registeredUser: User? = null
    private val TAG = "SignInFragment"

    private val STATIC_LOGIN = "user"
    private val STATIC_PASSWORD = "user"

    @Nullable
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.activity_auth, container, false)

        registeredUser = arguments?.getSerializable("user") as? User

        val emailEditText: EditText = view.findViewById(R.id.emailEditText)
        val passwordEditText: EditText = view.findViewById(R.id.passwordEditText)
        val loginButton: Button = view.findViewById(R.id.signInButton)
        val notRegisterYet: TextView = view.findViewById(R.id.registerPromptTextView)

        loginButton.setOnClickListener {
            val login = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Пожалуйста, введите логин и пароль", Toast.LENGTH_SHORT).show()
            } else if (login == STATIC_LOGIN && password == STATIC_PASSWORD) {
                (activity as MainActivity).navigateToHome()
            } else if (registeredUser != null && login == registeredUser?.email && password == registeredUser?.password) {
                (activity as MainActivity).navigateToHome()
            } else {
                Toast.makeText(context, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }

        notRegisterYet.setOnClickListener {
            (activity as MainActivity).navigateToRegister()
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