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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.CommunityItem
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.viewmodel.CommunityListViewModel

class CommunityScreen {
    @Composable

    fun CommunityList(community : List<CommunityItem>){
        LazyColumn{
            item {
                Row (modifier = Modifier.fillMaxSize()
                    .padding(vertical = 10.dp)){
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp))
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(text = "Komunitas baru", fontSize = 22.sp, color = Color.White, modifier = Modifier.padding(vertical = 10.dp))
                    }
                }
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
            }

            items(community){comm ->

                Row(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Image(
                        painter = painterResource(comm.photo),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(text = comm.title, fontSize = 22.sp, color = Color.White)
                        Text(text = comm.chat, fontSize = 16.sp, color = Color.White)
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
    
    fun PreviewCommunity(){
        WhatsAppTheme {
            Surface (modifier = Modifier.fillMaxSize()){
                CommunityList(community = CommunityListViewModel().community)
            }
        }
    }
}