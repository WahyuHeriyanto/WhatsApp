package com.wahyuheriyanto.whatsapp.data.model

data class User(
    val id: String = "",          // ID unik pengguna, default ke string kosong
    val name: String = "",        // Nama pengguna
    val email: String = "",       // Email pengguna
    val profilePictureUrl: String = "" // URL untuk gambar profil pengguna
)