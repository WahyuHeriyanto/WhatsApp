package com.wahyuheriyanto.whatsapp.data.model

import android.net.Uri

data class MediaFile(
    val uri: Uri,
    val type: MediaType
)

enum class MediaType {
    PHOTO, VIDEO
}
