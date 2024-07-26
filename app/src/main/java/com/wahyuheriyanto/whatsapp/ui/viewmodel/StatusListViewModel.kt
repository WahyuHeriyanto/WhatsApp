package com.wahyuheriyanto.whatsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.wahyuheriyanto.whatsapp.R
import com.wahyuheriyanto.whatsapp.data.model.MyStatus
import com.wahyuheriyanto.whatsapp.data.model.StatusItem

class StatusListViewModel : ViewModel() {

    private val _status = MutableStateFlow<List<StatusItem>>(emptyList())

    val status: StateFlow<List<StatusItem>> = _status

    private val _mystatus = MutableStateFlow<List<MyStatus>>(emptyList())
    val mystatus: StateFlow<List<MyStatus>> = _mystatus

    private val db : FirebaseFirestore = Firebase.firestore

    init {
        fetchstatus()
        fetchMyStatus()

    }

    private fun fetchstatus(){
        db.collection("status")
            .get()
            .addOnSuccessListener { result ->
                val statusList = mutableListOf<StatusItem>()
                for (document in result) {
                    val name = document.getString("name") ?: ""
                    val time = document.getString("time") ?: ""
                    val photo =  R.drawable.camera_logo
                    statusList.add(StatusItem(name, time, photo))

                }
                _status.value = statusList
                Log.d("Firestore", "Data fetched: $statusList")
            }
            .addOnFailureListener{exception ->
                exception.printStackTrace()
                Log.e("Firestore", "Error getting documents: ", exception)

            }
    }

    private fun fetchMyStatus() {
        db.collection("mystatus")
            .get()
            .addOnSuccessListener { result ->
                val myStatusList = mutableListOf<MyStatus>()
                for (document in result) {
                    val photo = R.drawable.camera_logo
                    myStatusList.add(MyStatus(photo))
                }
                _mystatus.value = myStatusList
                Log.d("Firestore", "Data fetched: $myStatusList")

            }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
                Log.e("Firestore", "Error getting documents: ", exception)
                // Handle failure
            }
    }

    fun updateMyStatus(newMyStatus: List<MyStatus>) {
        _mystatus.value = newMyStatus
    }

    fun updateStatus(newStatus : List<StatusItem>) {
        _status.value = newStatus
    }

}