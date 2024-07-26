package com.wahyuheriyanto.whatsapp.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.wahyuheriyanto.whatsapp.data.model.MediaFile
import com.wahyuheriyanto.whatsapp.data.repository.MediaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CameraViewModel(private val repository: MediaRepository) : ViewModel() {

    private val _mediaFiles = MutableStateFlow<List<MediaFile>>(emptyList())
    val mediaFiles: StateFlow<List<MediaFile>> get() = _mediaFiles

    fun addPhoto(uri: Uri) {
        val newMediaFile = repository.savePhoto(uri)
        _mediaFiles.value = _mediaFiles.value + newMediaFile
    }

    fun addVideo(uri: Uri) {
        val newMediaFile = repository.saveVideo(uri)
        _mediaFiles.value = _mediaFiles.value + newMediaFile
    }
}
