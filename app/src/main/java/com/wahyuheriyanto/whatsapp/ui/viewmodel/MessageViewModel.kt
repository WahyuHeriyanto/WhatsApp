package com.wahyuheriyanto.whatsapp.ui.viewmodel

import com.wahyuheriyanto.whatsapp.data.model.Message
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MessageViewModel : ViewModel() {

    private val db = FirebaseFirestore.getInstance()
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> get() = _messages

    init {
        fetchMessages()
    }

    private fun fetchMessages() {
        db.collection("messages").orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                val messageList = mutableListOf<Message>()
                snapshots?.let {
                    for (doc in it) {
                        val message = doc.toObject(Message::class.java)
                        messageList.add(message)
                    }
                }
                _messages.value = messageList
            }
    }

    fun sendMessage(message: Message) {
        db.collection("messages").add(message)
    }



}