package com.example.laba1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laba1.R
import com.example.laba1.data.User
import com.example.laba1.fragments.HomeFragment
import com.example.laba1.fragments.OnboardFragment
import com.example.laba1.fragments.SignInFragment
import com.example.laba1.fragments.SignUpFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardFragment())
                .commit()
        }
    }

    fun navigateToAuth(registeredUser: User?) {
        val signInFragment = SignInFragment()
        val args = Bundle()
        args.putSerializable("user", registeredUser)
        signInFragment.arguments = args

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, signInFragment)
            .addToBackStack(null)
            .commit()
    }

    fun navigateToRegister() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignUpFragment())
            .addToBackStack(null)
            .commit()
    }

    fun navigateToHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
}