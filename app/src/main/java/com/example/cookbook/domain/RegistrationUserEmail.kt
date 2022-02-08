package com.example.cookbook.domain

import android.content.Intent
import android.widget.Toast
import com.example.cookbook.LoginActivity
import com.example.cookbook.MainMenuActivity
import com.example.cookbook.R
import com.example.cookbook.RegistrationActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

/** Class regisration user Email**/
class RegistrationUserEmail {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    internal fun registrUser(email:String, password:String, registrationActivity: RegistrationActivity){

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.createUserWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        checkLoggedInState(registrationActivity)

                    }
                } catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(registrationActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkLoggedInState(registrationActivity: RegistrationActivity) {
        val regIntent = Intent(registrationActivity, MainMenuActivity::class.java)
        if (auth.currentUser == null) {
            Toast.makeText(registrationActivity, R.string.no_logged, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(registrationActivity, R.string.logged, Toast.LENGTH_LONG).show()
            registrationActivity.startActivity(regIntent)
        }
    }
}