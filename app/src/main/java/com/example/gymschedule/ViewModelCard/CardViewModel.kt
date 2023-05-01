package com.example.gymschedule.ViewModelCard
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymschedule.DT.CardItem

class CardViewModel: ViewModel() {
    private val _selectedCardItem = MutableLiveData<CardItem>()

    fun onCardItemClick(cardItem: CardItem) {
        Log.d("CardViewModel", "onCardItemClick called with $cardItem")
        _selectedCardItem.value = cardItem
    }
}