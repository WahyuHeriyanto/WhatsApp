package com.wahyuheriyanto.whatsapp.data.repository

import android.content.Context
import android.net.Uri
import com.wahyuheriyanto.whatsapp.data.model.MediaFile
import com.wahyuheriyanto.whatsapp.data.model.MediaType

class MediaRepository(private val context: Context) {

    fun savePhoto(uri: Uri): MediaFile {
        return MediaFile(uri, MediaType.PHOTO)
    }

    fun saveVideo(uri: Uri): MediaFile {
        return MediaFile(uri, MediaType.VIDEO)
    }

    // You can add more functions for complex operations if needed
}
