package com.example.cookbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookbook.databinding.ActivityRegistrationBinding
import com.example.cookbook.domain.RegistrationUserEmail

class RegistrationActivity : AppCompatActivity() {

    private lateinit var bindingRegistration: ActivityRegistrationBinding
    private val registrationUserEmail = RegistrationUserEmail()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRegistration = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingRegistration.root)

        bindingRegistration.regBtn.setOnClickListener {
            val email = bindingRegistration.regInputLogin.text.toString()
            val password = bindingRegistration.regInputPassword.text.toString()
            registrationUserEmail.registrUser(email,password,this@RegistrationActivity)
        }
    }
}