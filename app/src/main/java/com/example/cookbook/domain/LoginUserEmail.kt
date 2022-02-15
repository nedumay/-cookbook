package com.example.cookbook.domain

import android.app.ProgressDialog
import android.content.Intent
import android.widget.Toast
import com.example.cookbook.R
import com.example.cookbook.ui.LoginActivity
import com.example.cookbook.ui.MainActivityMenu
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*

import kotlinx.coroutines.tasks.await

/** Class login users email **/
class LoginUserEmail {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var progDialog: ProgressDialog

    internal  fun loginUser(email:String, password:String, loginActivity: LoginActivity){
        progDialog = ProgressDialog(loginActivity)
        progDialog.setTitle(R.string.loading)
        progDialog.setMessage(loginActivity.getResources().getString(R.string.check))

        if(email.isNotEmpty() && password.isNotEmpty()){

            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.signInWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        progDialog.show()
                        delay(5000)
                        checkLoggedInState(loginActivity)
                        progDialog.dismiss()
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
        val logIntent = Intent(loginActivity, MainActivityMenu::class.java)
        if(auth.currentUser == null){
            Toast.makeText(loginActivity, R.string.no_log, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(loginActivity, R.string.logged, Toast.LENGTH_SHORT).show()
            loginActivity.startActivity(logIntent)
        }
    }
}




