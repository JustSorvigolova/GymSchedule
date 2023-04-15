package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymschedule.DT.CardItem
import com.example.gymschedule.cardAdapter.CardAdapter
import com.example.gymschedule.databinding.FragmentHomeBinding


class fragment_home : Fragment() {

    private var binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container,
           false)
        val cardItems = createCardItems()
        val recyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CardAdapter(cardItems)
        return binding!!.root
    }
    private fun createCardItems(): List<CardItem> {
        val cardItems = mutableListOf<CardItem>()
        cardItems.add(CardItem("Бицепс",  R.drawable.b_1))
        cardItems.add(CardItem("Трицепс",  R.drawable.b_2))
        cardItems.add(CardItem("Грудь",  R.drawable.b_3))
        cardItems.add(CardItem("Спина",  R.drawable.b_4))
        cardItems.add(CardItem("Ноги",  R.drawable.b_5))
        cardItems.add(CardItem("Плечи",  R.drawable.b_6))
        return cardItems
    }


}