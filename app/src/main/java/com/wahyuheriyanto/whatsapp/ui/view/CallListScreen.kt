package com.wahyuheriyanto.whatsapp.ui.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.CallItem
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.viewmodel.CallListViewModel

class CallListScreen {

    @Composable
    fun CallList(viewModel: CallListViewModel){
        val calls = viewModel.call.collectAsState(emptyList())
        LazyColumn{
            item {
                Column {
                    Text(text = "Favorit", modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp), fontSize = 20.sp)
                    Row {
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "", modifier = Modifier.size(50.dp))
                        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                        Text(text = "Tambah ke Favorit", fontSize = 22.sp, modifier = Modifier.padding(vertical = 10.dp))
                    }
                    Text(text = "Terbaru", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp))
                }
            }

            items(calls.value){call ->
                Row(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Image(
                        painter = painterResource(call.photo),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(
                    ) {
                        Text(text = call.name, fontSize = 18.sp, color = Color.White)
                        Text(text = call.time, fontSize = 14.sp, color = Color.White)
                        Spacer(modifier = Modifier.padding(vertical = 18.dp))
                    }
                    Image(painter = painterResource(id = R.drawable.call_icon), contentDescription = "", modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 15.dp))
                }
            }
        }
    }
    
    @Preview (name = "Dark Mode",
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true)
    @Composable

    fun PreviewCall(){
        WhatsAppTheme {
            Surface (modifier = Modifier.fillMaxSize()) {
                CallList(viewModel = CallListViewModel())
            }
        }
    }
}