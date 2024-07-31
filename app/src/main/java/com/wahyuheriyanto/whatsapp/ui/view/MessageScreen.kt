package com.wahyuheriyanto.whatsapp.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.viewmodel.MessageViewModel

@Composable
fun MessageScreen(viewModel: MessageViewModel, chatName: String) {
    val messages by viewModel.messages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { message ->
                Text(text = chatName, color = Color.Black)
                Text(text = "${message.senderId}: ${message.content}", color = Color.Black)
            }
        }

        var messageText by remember { mutableStateOf("") }

        Row {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Enter your message", color = Color.Black) }
            )
            Button(onClick = {
                val message = com.wahyuheriyanto.whatsapp.data.model.Message(
                    senderId = "user1",
                    receiverId = "user2",
                    content = messageText
                )
                viewModel.sendMessage(message)
                messageText = ""
            }) {
                Text(text = "Send")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageScreenPreview() {
    WhatsAppTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            MessageScreen(viewModel = MessageViewModel(), chatName = "chatName")
        }
    }
}