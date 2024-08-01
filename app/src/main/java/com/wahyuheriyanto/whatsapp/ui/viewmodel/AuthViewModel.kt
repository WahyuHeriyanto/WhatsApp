package com.wahyuheriyanto.whatsapp.ui.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.wahyuheriyanto.whatsapp.data.repository.AuthRepository
import com.wahyuheriyanto.whatsapp.HomeActivity
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val auth = FirebaseAuth.getInstance()
    private val repository = AuthRepository(auth)

    val currentUser = repository.currentUser

    fun loginWithEmailPassword(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        viewModelScope.launch {
            try {
                repository.loginWithEmailPassword(email, password)
                onSuccess()
            } catch (e: Exception) {
                onFailure(e.message.toString())
            }
        }
    }

    fun loginWithGoogle(idToken: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        viewModelScope.launch {
            try {
                repository.loginWithGoogle(idToken)
                onSuccess()
            } catch (e: Exception) {
                onFailure(e.message.toString())
            }
        }
    }

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            repository.registerUser(email, password)
        }
    }
}
