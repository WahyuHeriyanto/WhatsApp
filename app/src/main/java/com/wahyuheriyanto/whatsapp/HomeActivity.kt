package com.wahyuheriyanto.whatsapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.FirebaseApp
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.view.LoginScreen
import com.wahyuheriyanto.whatsapp.ui.view.NavigationBar
import com.wahyuheriyanto.whatsapp.ui.viewmodel.AuthViewModel

class HomeActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent{
            WhatsAppTheme {
                Surface {
                    //NavigationBar().ViewButtonNavbar()
                    val authViewModel: AuthViewModel by viewModels()
                    LoginScreen(viewModel = authViewModel)
                }
            }
        }
    }
}

@Preview (name = "Light Mode")
@Preview(name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable

fun PreviewNav(){
    WhatsAppTheme {
        Surface (modifier = Modifier.fillMaxSize()){
            NavigationBar().ViewButtonNavbar()

        }
    }
}

