package com.wahyuheriyanto.whatsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.NavigationItem
import com.wahyuheriyanto.whatsapp.data.model.TopNavigationItem

class NavigationViewModel : ViewModel() {

    val items = listOf(
        NavigationItem(name = "Chat", route = "chat", selectedIcon = R.drawable.chat_icon, unselectedIcon = R.drawable.unselected_chat_icon, notify = true, badges = 48),
        NavigationItem(name = "Pembaruan", route = "status", selectedIcon = R.drawable.status_icon, unselectedIcon = R.drawable.unselected_status_icon, notify = true, badges = 0),
        NavigationItem(name = "Komunitas", route = "community", selectedIcon = R.drawable.community_icon, unselectedIcon = R.drawable.unselected_community_icon, notify = false, badges = 0),
        NavigationItem(name = "Panggilan", route = "call", selectedIcon = R.drawable.selected_call_icon, unselectedIcon = R.drawable.call_icon, notify = false, badges = 0)

    )

    val topitems = listOf(
        TopNavigationItem(route = "camera", selectedIcon = R.drawable.camera_logo, unselectedIcon = R.drawable.camera_logo),
        TopNavigationItem(route = "search", selectedIcon = R.drawable.search_icon, unselectedIcon = R.drawable.search_icon),
        TopNavigationItem(route = "option", selectedIcon = R.drawable.three_dot_icon, unselectedIcon = R.drawable.three_dot_icon)

    )
}