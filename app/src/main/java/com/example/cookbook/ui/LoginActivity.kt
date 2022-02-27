package com.example.cookbook.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cookbook.databinding.ActivityLoginBinding
import com.example.cookbook.domain.LoginUserEmail

class LoginActivity: AppCompatActivity() {

    private lateinit var bindingLogin: ActivityLoginBinding
    private val loginUserEmail = LoginUserEmail()
    private lateinit var loginPreferences: SharedPreferences
    private lateinit var loginPrefsEditor: SharedPreferences.Editor
    private var saveLogin: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {

        bindingLogin = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingLogin.root)

        /** Вход в режиме гостя **/
        val loginIntent = Intent(this@LoginActivity, MainActivityMenu::class.java)
        bindingLogin.guestBtn.setOnClickListener {
            startActivity(loginIntent)
        }

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE)
        loginPrefsEditor = loginPreferences.edit()
        saveLogin = loginPreferences.getBoolean("saveLogin", false)

        /** Вход через аккаунт **/
        var email:String
        var password:String
        bindingLogin.loginBtn.setOnClickListener {
            email = bindingLogin.inputLogin.text.toString()
            password = bindingLogin.inputPassword.text.toString()
            loginUserEmail.loginUser(email, password, this@LoginActivity)
        }
        if(saveLogin){
            bindingLogin.inputLogin.setText(loginPreferences.getString("username"," "))
            bindingLogin.inputPassword.setText(loginPreferences.getString("password"," "))
            bindingLogin.chekLogin.isChecked = true
        }
    }

    fun saveLogin(view: View) {
        if (view == bindingLogin.chekLogin){
            val username = bindingLogin.inputLogin.text.toString()
            val password = bindingLogin.inputPassword.text.toString()
            if(bindingLogin.chekLogin.isChecked){
                loginPrefsEditor.putBoolean("saveLogin", true)
                loginPrefsEditor.putString("username", username)
                loginPrefsEditor.putString("password",password)
                loginPrefsEditor.commit()
            } else {
                loginPrefsEditor.clear()
                loginPrefsEditor.commit()
            }
        }
    }

}