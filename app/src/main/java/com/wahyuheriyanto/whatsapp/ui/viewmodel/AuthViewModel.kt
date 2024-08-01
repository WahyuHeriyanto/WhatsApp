package com.wahyuheriyanto.whatsapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import com.wahyuheriyanto.whatsapp.data.model.User
import com.wahyuheriyanto.whatsapp.data.repository.AuthRepository

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()
    private val repository = AuthRepository(auth, firestore)

    val currentUser = repository.currentUser

    fun loginWithEmailPassword(email: String, password: String) {
        viewModelScope.launch {
            repository.loginWithEmailPassword(email, password)
        }
    }

    fun loginWithGoogle(idToken: String) {
        viewModelScope.launch {
            repository.loginWithGoogle(idToken)
        }
    }

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            repository.registerUser(email, password)
        }
    }

    fun saveUserData(user: User) {
        viewModelScope.launch {
            repository.saveUserData(user)
        }
    }
}
