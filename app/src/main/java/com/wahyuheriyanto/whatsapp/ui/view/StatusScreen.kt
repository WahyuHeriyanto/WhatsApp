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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.viewmodel.StatusListViewModel


class StatusScreen {
    @Composable
    fun StatusList(viewModel: StatusListViewModel) {

        val statusItems = viewModel.status.collectAsState(initial = emptyList())
        val myStatusItems = viewModel.mystatus.collectAsState(initial = emptyList())

        LazyColumn {
            item {
                    Text(text = "Status", color = Color.White, modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp), fontSize = 20.sp)
            }
            items (myStatusItems.value) { mystat->
                Row (modifier = Modifier.fillMaxSize()){
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Image(painter = painterResource(id = mystat.photo),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp))
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(text = "Status saya", fontSize = 22.sp, color = Color.White)
                        Text(text = "Ketuk untuk memperbaharui", fontSize = 16.sp, color = Color.White)
                        Spacer(modifier = Modifier.padding(vertical = 18.dp))
                    }
                }
            }

            item {
                Text(text = "Pembaruan terkini", color = Color.White, modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp), fontSize = 16.sp)
            }

            items(statusItems.value) { stat ->
                Row(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Image(
                        painter = painterResource(stat.photo),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(text = stat.name, fontSize = 22.sp, color = Color.White)
                        Text(text = stat.time, fontSize = 16.sp, color = Color.White)
                        Spacer(modifier = Modifier.padding(vertical = 18.dp))
                    }
                }
            }
        }
    }

    @Preview (name = "Dark Mode",
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true)
    @Composable

    fun PreviewView(){
        WhatsAppTheme {
            Surface {
                StatusList(viewModel = StatusListViewModel())
            }
        }
    }
}

