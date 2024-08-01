package com.wahyuheriyanto.whatsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.google.firebase.FirebaseApp
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme
import com.wahyuheriyanto.whatsapp.ui.view.LoginScreen
import com.wahyuheriyanto.whatsapp.ui.viewmodel.AuthViewModel

class LoginActivity : ComponentActivity(){

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