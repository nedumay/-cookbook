package com.example.cookbook


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val email = bindingLogin.inputLogin.text.toString()
            val password = bindingLogin.inputPassword.text.toString()
            loginUserEmail.loginUser(email,password, this@LoginActivity)
        }
    }
}