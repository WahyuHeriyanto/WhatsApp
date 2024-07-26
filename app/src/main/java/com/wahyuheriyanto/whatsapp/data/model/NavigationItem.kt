package com.wahyuheriyanto.whatsapp.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val name: String,
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val notify: Boolean,
    val badges: Int
                            )

data class TopNavigationItem(
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int)