package com.example.gymschedule.Data
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase




class UploadViewModelShoulders: ViewModel() {

    private val database = FirebaseDatabase.getInstance().reference.child("shoulders")

    fun sendDataToFirebase(title: String, desc: String, imageURL: String?) {
        val data = Data_Card(title, desc, imageURL)
        database.push().setValue(data)
    }

}
