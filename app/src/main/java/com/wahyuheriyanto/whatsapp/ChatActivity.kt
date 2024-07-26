package com.wahyuheriyanto.whatsapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.view.MessageScreen
import com.wahyuheriyanto.whatsapp.ui.viewmodel.MessageViewModel

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            WhatsAppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    MessageScreen(viewModel = MessageViewModel())
                }
            }
        }
    }
}