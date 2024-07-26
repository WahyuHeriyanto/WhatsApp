package com.wahyuheriyanto.whatsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.ChatItem

class ChatListViewModel : ViewModel() {


    val chats = listOf(
        ChatItem(name = "Alif Rizky", message = "Info lab pak", photo = R.drawable.camera_logo),
        ChatItem(name = "Heri", message = "Coba", photo = R.drawable.camera_logo),
        ChatItem(name = "Ilham Alghifari", message = "Lagi tangi aku ki", photo = R.drawable.camera_logo),
        ChatItem(name = "Aldi Fahli", message = "Proposal tekan endi", photo = R.drawable.camera_logo),
        ChatItem(name = "Asri Aziziyah", message = "Aku lagi makan", photo = R.drawable.camera_logo),
        ChatItem(name = "Rahmat Rohmani", message = "Kunci lab nangdi?", photo = R.drawable.camera_logo)

    )

}