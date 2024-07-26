package com.wahyuheriyanto.whatsapp.ui.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.ui.theme.WhatsAppTheme

class SplashScreen {

    @Composable
    fun ScreenView() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxSize()
            ) {
                val (logo, text, title) = createRefs()
                val guideline = createGuidelineFromTop(0.4f)
                val guidelineBottom = createGuidelineFromBottom(0.1f)
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_icon_white),
                    contentDescription = null,
                    modifier = Modifier.constrainAs(logo) {
                        top.linkTo(guideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                        .size(100.dp)
                )
                Text(
                    text = "from",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.constrainAs(text) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(title.top, margin = 5.dp)
                    }
                )
                Text(
                    text = "Wahyu Heriyanto",
                    color = Color.White,
                    fontSize = 17.sp,
                    modifier = Modifier.constrainAs(title) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(guidelineBottom)
                    },
                )
            }
        }
    }
    @Preview(name = "Light Mode")
    @Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
    @Composable
    fun PreviewScreen() {
        WhatsAppTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                ScreenView()
            }
        }
    }
}
