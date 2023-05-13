package com.example.gymschedule.ViewModelCard
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gymschedule.DT.CardItem

class CardViewModel: ViewModel() {
    private val _selectedCardItem = MutableLiveData<CardItem>()

    fun onCardItemClick(cardItem: CardItem) {
        _selectedCardItem.value = cardItem
    }
}