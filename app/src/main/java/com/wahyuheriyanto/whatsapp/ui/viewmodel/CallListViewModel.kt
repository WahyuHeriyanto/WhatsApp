package com.wahyuheriyanto.whatsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.CallItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CallListViewModel : ViewModel() {

    private val _call = MutableStateFlow<List<CallItem>>(emptyList())
    val call : StateFlow<List<CallItem>> = _call

    init {
        _call.value = listOf(
            CallItem(photo = R.drawable.camera_logo, name = "Aldi Fahli Muzaqih (2)", time = "Kemarin 21.02"),
            CallItem(photo = R.drawable.camera_logo, name = "Aldi Fahli Muzaqih (2)", time = "Kemarin 21.02"),
            CallItem(photo = R.drawable.camera_logo, name = "Aldi Fahli Muzaqih (2)", time = "Kemarin 21.02"),
            CallItem(photo = R.drawable.camera_logo, name = "Aldi Fahli Muzaqih (2)", time = "Kemarin 21.02"),
            CallItem(photo = R.drawable.camera_logo, name = "Aldi Fahli Muzaqih (2)", time = "Kemarin 21.02")
        )
    }
}

