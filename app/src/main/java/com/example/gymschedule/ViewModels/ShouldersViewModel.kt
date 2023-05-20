package com.example.gymschedule.ViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymschedule.DT.Data_Card
import com.google.firebase.database.*


class ShouldersViewModel: ViewModel() {

    private val database = FirebaseDatabase.getInstance().reference.child("shoulders")
    private val itemList: MutableLiveData<List<Data_Card>> = MutableLiveData()
    private val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("shoulders")



    fun sendDataToFirebase(title: String, desc: String, imageURL: String?) {
        val data = Data_Card(title, desc, imageURL)
        database.push().setValue(data)
    }



    fun getItemList(): LiveData<List<Data_Card>> {
        return itemList
    }

    fun loadData() {
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<Data_Card>()
                for (itemSnapshot in snapshot.children) {
                    val title = itemSnapshot.child("title").value.toString()
                    val desc = itemSnapshot.child("desc").value.toString()
                    val imageURL = itemSnapshot.child("imageURL").value.toString()
                    val item = Data_Card(title, desc, imageURL)
                    items.add(item)
                }
                itemList.value = items
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
