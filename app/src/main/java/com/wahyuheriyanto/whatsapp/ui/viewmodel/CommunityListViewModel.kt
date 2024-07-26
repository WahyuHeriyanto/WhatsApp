package com.wahyuheriyanto.whatsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.CommunityItem

class CommunityListViewModel : ViewModel() {

    val community = listOf(
        CommunityItem(photo = R.drawable.camera_logo, title = "Pengumuman", chat = "~ Heri: Info pak..."),
        CommunityItem(photo = R.drawable.camera_logo, title = "Pengumuman", chat = "~ Heri: Info pak..."),
        CommunityItem(photo = R.drawable.camera_logo, title = "Pengumuman", chat = "~ Heri: Info pak..."),
        CommunityItem(photo = R.drawable.camera_logo, title = "Pengumuman", chat = "~ Heri: Info pak..."),
        CommunityItem(photo = R.drawable.camera_logo, title = "Pengumuman", chat = "~ Heri: Info pak...")
    )
}