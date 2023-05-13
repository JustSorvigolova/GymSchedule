package com.example.gymschedule.Data
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase




class UploadViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance().reference.child("biceps")

    fun sendDataToFirebase(title: String, desc: String, imageURL: String?) {
        val data = Data_Biceps(title, desc, imageURL)
        database.push().setValue(data)
    }

}
