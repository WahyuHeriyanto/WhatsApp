package com.wahyuheriyanto.whatsapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.wahyuheriyanto.whatsapp.data.model.User
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {
    val currentUser get() = auth.currentUser

    suspend fun loginWithEmailPassword(email: String, password: String) {
        try {
            auth.signInWithEmailAndPassword(email, password).await()
        } catch (e: Exception) {
            // Handle error
        }
    }

    suspend fun loginWithGoogle(idToken: String) {
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential).await()
        } catch (e: Exception) {
            // Handle error
        }
    }

    suspend fun registerUser(email: String, password: String) {
        try {
            auth.createUserWithEmailAndPassword(email, password).await()
        } catch (e: Exception) {
            // Handle error
        }
    }

    suspend fun saveUserData(user: User) {
        try {
            user.id?.let {
                firestore.collection("users").document(it).set(user).await()
            }
        } catch (e: FirebaseFirestoreException) {
            // Handle error
        }
    }
}