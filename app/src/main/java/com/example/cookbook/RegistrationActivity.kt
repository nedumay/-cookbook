package com.example.cookbook


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var inputLogin: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()
        inputLogin = findViewById(R.id.reg_input_login)
        inputPassword = findViewById(R.id.reg_input_password)
        val btnReg:Button = findViewById(R.id.reg_btn)

        btnReg.setOnClickListener {
            registrUser()
        }
    }

    /** Регистрация юзера **/
    private fun registrUser(){
        val email = inputLogin.text.toString()
        val password = inputPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.createUserWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState()
                    }
                } catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@RegistrationActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }

            }
        }

    }

    private fun checkLoggedInState() {
        val loginIntent = Intent(this@RegistrationActivity, MainMenuActivity::class.java)
        if(auth.currentUser == null){
            Toast.makeText(applicationContext,R.string.no_logged,Toast.LENGTH_LONG).show()
            startActivity(loginIntent)
        } else {
            Toast.makeText(applicationContext,R.string.logged,Toast.LENGTH_LONG).show()
            startActivity(loginIntent)

        }
    }


}