package com.example.cookbook


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cookbook.databinding.ActivityRegistrationBinding
import com.example.cookbook.domain.RegistrationUserEmail
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

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