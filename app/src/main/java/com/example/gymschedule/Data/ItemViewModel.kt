package com.example.gymschedule.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*

class ItemViewModel : ViewModel() {
    private val databaseRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("biceps")
    private val itemList: MutableLiveData<List<Data_Card>> = MutableLiveData()

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
                // Обработка ошибок чтения данных
            }
        })
    }
}