package com.example.gymschedule.Data
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase




class UploadViewModelBack: ViewModel() {

    private val database = FirebaseDatabase.getInstance().reference.child("back")

    fun sendDataToFirebase(title: String, desc: String, imageURL: String?) {
        val data = Data_Card(title, desc, imageURL)
        database.push().setValue(data)
    }

}
