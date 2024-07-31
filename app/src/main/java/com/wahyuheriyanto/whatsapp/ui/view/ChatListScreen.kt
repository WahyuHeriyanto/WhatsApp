package com.wahyuheriyanto.whatsapp.ui.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahyuheriyanto.whatsapp.ChatActivity
import com.wahyuheriyanto.whatsapp.data.model.ChatItem
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme


class ChatListScreen {

    @Composable
    fun ChatList(chats: List<ChatItem>){
        val context = LocalContext.current
        LazyColumn{
            items(chats){chat->
                Row (modifier = Modifier.fillMaxSize()
                    .clickable {
                        val intent = Intent(context, ChatActivity::class.java)
                        intent.putExtra("chat_name", chat.name)
                        context.startActivity(intent)
                    }){
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Image(painter = painterResource(chat.photo), contentDescription ="",modifier = Modifier.size(50.dp))
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(modifier = Modifier
                        .fillMaxSize()) {
                        Text(text = chat.name, fontSize = 22.sp, color = Color.White)
                        Text(text = chat.message, fontSize = 16.sp, color = Color.White)
                        Spacer(modifier = Modifier.padding(vertical = 18.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable

fun PreviewChatScreen(){
    WhatsAppTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            ChatListScreen()
        }
    }
}