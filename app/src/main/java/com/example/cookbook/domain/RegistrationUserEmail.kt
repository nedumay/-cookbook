package com.example.cookbook.domain

import android.app.ProgressDialog
import android.content.Intent
import android.widget.Toast
import com.example.cookbook.R
import com.example.cookbook.presentation.ui.MainActivityMenu
import com.example.cookbook.presentation.ui.registration.RegistrationActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

/** Class regisration user Email**/
class RegistrationUserEmail {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var progDialog: ProgressDialog

    internal fun registrUser(email:String, password:String, registrationActivity: RegistrationActivity){
        progDialog = ProgressDialog(registrationActivity)
        progDialog.setTitle(R.string.loading)
        progDialog.setMessage(registrationActivity.resources.getString(R.string.check))

        if(email.isNotEmpty() && password.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch{
                try {
                    auth.createUserWithEmailAndPassword(email,password).await()
                    withContext(Dispatchers.Main){
                        progDialog.show()
                        delay(5000)
                        checkLoggedInState(registrationActivity)
                        progDialog.dismiss()

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
        val regIntent = Intent(registrationActivity, MainActivityMenu::class.java)
        if (auth.currentUser == null) {
            Toast.makeText(registrationActivity, R.string.no_logged, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(registrationActivity, R.string.logged, Toast.LENGTH_LONG).show()
            registrationActivity.startActivity(regIntent)
        }
    }
}