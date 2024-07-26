package com.wahyuheriyanto.whatsapp

import com.wahyuheriyanto.whatsapp.ui.view.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.firebase.FirebaseApp
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : ComponentActivity() {

    private val SPLASH_SCREEN_TIME :Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            WhatsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen().ScreenView()
                }
            }
        }
        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, SPLASH_SCREEN_TIME)

    }
}



