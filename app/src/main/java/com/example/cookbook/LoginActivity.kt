package com.example.cookbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookbook.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var bindingLogin: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingLogin.root)
    }

    override fun onResume() {
        super.onResume()
        val loginIntent = Intent(this@LoginActivity, MainMenuActivity::class.java)
        bindingLogin.guestBtn.setOnClickListener{
            startActivity(loginIntent)
        }
    }
}