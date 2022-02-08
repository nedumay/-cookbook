package com.example.cookbook.domain

import android.content.Intent
import android.widget.Toast
import com.example.cookbook.LoginActivity
import com.example.cookbook.MainMenuActivity
import com.example.cookbook.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.tasks.await

/** Class login users email **/
class LoginUserEmail {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    internal  fun loginUser(email:String, password:String, loginActivity: LoginActivity){

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState(loginActivity)
                    }
                } catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(loginActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    private fun checkLoggedInState( loginActivity: LoginActivity){
        val logIntent = Intent(loginActivity, MainMenuActivity::class.java)
       if(auth.currentUser == null){
            Toast.makeText(loginActivity, R.string.no_log, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(loginActivity, R.string.logged, Toast.LENGTH_LONG).show()
           loginActivity.startActivity(logIntent)
        }
    }
}