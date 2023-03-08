package com.example.cookbook.presentation.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookbook.databinding.ActivityMainBinding
import com.example.cookbook.presentation.ui.login.LoginActivity
import com.example.cookbook.presentation.ui.registration.RegistrationActivity

class MainActivity : AppCompatActivity() {

    lateinit var bindingStart: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingStart = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingStart.root)

        bindingStart.loginBtn.setOnClickListener{
            val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(loginIntent)

        }
        bindingStart.registrBtn.setOnClickListener{
            val registrActivity = Intent(this@MainActivity, RegistrationActivity::class.java)
            startActivity(registrActivity)

        }
    }
}