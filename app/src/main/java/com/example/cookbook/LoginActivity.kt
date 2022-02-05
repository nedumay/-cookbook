package com.example.cookbook

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cookbook.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var bindingLogin: ActivityLoginBinding
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
        bindingLogin.loginBtn.setOnClickListener {
            registrUser()
        }
    }
    
    /** Логин юзера **/
    private fun registrUser(){
        val email = bindingLogin.inputLogin.text.toString()
        val password = bindingLogin.inputPassword.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState()
                    }
                } catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }

            }
        }

    }

    private fun checkLoggedInState() {
        val loginIntent = Intent(this@LoginActivity, MainMenuActivity::class.java)
        if(auth.currentUser == null){
            Toast.makeText(applicationContext,R.string.no_log,Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext,R.string.logged,Toast.LENGTH_LONG).show()
            startActivity(loginIntent)

        }
    }
}