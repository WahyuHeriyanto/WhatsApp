package com.wahyuheriyanto.whatsapp.ui.view

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.wahyuheriyanto.whatsapp.ChatActivity
import com.wahyuheriyanto.whatsapp.ui.viewmodel.CallListViewModel
import com.wahyuheriyanto.whatsapp.ui.viewmodel.ChatListViewModel
import com.wahyuheriyanto.whatsapp.ui.viewmodel.CommunityListViewModel
import com.wahyuheriyanto.whatsapp.ui.viewmodel.MessageViewModel
import com.wahyuheriyanto.whatsapp.ui.viewmodel.NavigationViewModel
import com.wahyuheriyanto.whatsapp.ui.viewmodel.StatusListViewModel
import kotlinx.coroutines.launch


class NavigationBar {

    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
    @Composable
    fun ViewButtonNavbar(){
        var selected by remember {
            mutableIntStateOf(0)
        }

        var topSelected by remember {
            mutableIntStateOf(0)
        }

        val swipeableState = rememberSwipeableState(initialValue = 0)
        val widthPx = LocalContext.current.resources.displayMetrics.widthPixels.toFloat()
        val anchors = mapOf(
            3 * widthPx to 0,
            2 * widthPx to 1,
            1 * widthPx to 2,
            0f to 3
        )
        LaunchedEffect(swipeableState.currentValue) {
            selected = swipeableState.currentValue
        }
        val coroutineScope = rememberCoroutineScope()

        val context = LocalContext.current

        Scaffold(
            bottomBar = {
                NavigationBar{
                    NavigationViewModel().items.forEachIndexed{ index, NavigationItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                coroutineScope.launch {
                                    swipeableState.animateTo(index)
                                }
                                      },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (NavigationItem.badges !=0){
                                            Badge(containerColor = Color.Green) {
                                                Text(text = NavigationItem.badges.toString(), color = Color.Black)
                                            }
                                        } else if (NavigationItem.notify){
                                            Badge(containerColor = Color.Green)
                                        }
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(if (index == selected)
                                            NavigationItem.selectedIcon
                                        else
                                            NavigationItem.unselectedIcon)
                                        ,
                                        contentDescription = NavigationItem.name
                                    )
                                }
                            },
                            label = {
                                Text(text = NavigationItem.name)
                            }
                        )
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }, containerColor = Color.Green) {
                    Icon(imageVector = Icons.Filled.Create, contentDescription = "", tint = Color.Black)
                }

            },
            topBar = {
                Box {
                    ConstraintLayout {


                        NavigationBar(containerColor = Color.Transparent) {

                            Text(text = "WhatsApp", modifier = Modifier.padding(20.dp), fontSize = 25.sp, color = Color.White, fontStyle = FontStyle.Normal)
                            
                            Spacer(modifier = Modifier.width(70.dp))

                            NavigationViewModel().topitems.forEachIndexed { index, TopNavigationItem ->
                                NavigationBarItem(selected = index == topSelected,
                                    onClick = {
                                        topSelected = index
                                        handleTopBarItemClick(index, context)

                                    },
                                    icon = {
                                        Image(
                                            painter = painterResource(id = TopNavigationItem.selectedIcon),
                                            contentDescription = "",
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        ) {padding->
            val viewModel: MessageViewModel = viewModel()
            Box(modifier = Modifier
                .padding(padding)
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
                .fillMaxSize()
            ) {when (swipeableState.currentValue){
                0 -> ChatListScreen().ChatList(chats = ChatListViewModel().chats)
                1 -> StatusScreen().StatusList(viewModel = StatusListViewModel())
                2 -> CommunityScreen().CommunityList(community = CommunityListViewModel().community)
                //2 -> MessageScreen(viewModel = MessageViewModel())
                3 -> CallListScreen().CallList(viewModel = CallListViewModel())
            }
                //val padding = it
            }
        }
    }

    private fun handleTopBarItemClick(index: Int, context: Context) {
        when (index) {
            0 -> {
                // Navigate to ChatActivity
            }
            1 -> {
                // Navigate to CommunityActivity
                context.startActivity(Intent(context, ChatActivity::class.java))
            }
            2 -> {
                // Navigate to another activity
                context.startActivity(Intent(context, ChatActivity::class.java))
            }
            3 -> {
                // Navigate to yet another activity
                context.startActivity(Intent(context, ChatActivity::class.java))
            }
            // Add more cases as needed
        }
    }
}



