package com.example.cookbook

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.cookbook.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var bindingLogin: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingLogin.root)

        auth = FirebaseAuth.getInstance()
    }

    override fun onResume() {
        super.onResume()
        val loginIntent = Intent(this@LoginActivity, MainMenuActivity::class.java)
        bindingLogin.guestBtn.setOnClickListener{
            startActivity(loginIntent)
        }
    }
}