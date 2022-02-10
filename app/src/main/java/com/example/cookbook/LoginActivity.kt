package com.example.cookbook


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.example.cookbook.databinding.ActivityLoginBinding
import com.example.cookbook.domain.LoginUserEmail

class LoginActivity: AppCompatActivity() {

    private lateinit var bindingLogin: ActivityLoginBinding
    private val loginUserEmail = LoginUserEmail()

    override fun onCreate(savedInstanceState: Bundle?) {

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingLogin.root)

        val loginIntent = Intent(this@LoginActivity, MainMenuActivity::class.java)
        bindingLogin.guestBtn.setOnClickListener{
            startActivity(loginIntent)
        }

        bindingLogin.loginBtn.setOnClickListener {
            var email = bindingLogin.inputLogin.text.toString()
            var password = bindingLogin.inputPassword.text.toString()
            loginUserEmail.loginUser(email,password,this@LoginActivity)
        }
    }
}