package com.example.gymschedule
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymschedule.DT.CardItem
import com.example.gymschedule.ViewModels.CardViewModel
import com.example.gymschedule.cardAdapter.CardAdapter
import com.example.gymschedule.databinding.FragmentHomeBinding


class fragment_home : Fragment() {
    private var binding: FragmentHomeBinding? = null
    private lateinit var cardViewModel: CardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container,
           false)
        cardViewModel = ViewModelProvider(requireActivity())[CardViewModel::class.java]
        val cardItems = createCardItems()
        val recyclerView = binding!!.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CardAdapter(cardItems, cardViewModel)
        return binding!!.root
    }



    private fun createCardItems(): List<CardItem> {
        val cardItems = mutableListOf<CardItem>()
        cardItems.add(CardItem("Бицепс",  R.drawable.b_1, R.id.biceps_fragment))
        cardItems.add(CardItem("Трицепс",  R.drawable.b_2, R.id.triceps_fragment))
        cardItems.add(CardItem("Грудь",  R.drawable.b_3, R.id.chest_fragment))
        cardItems.add(CardItem("Спина",  R.drawable.b_4, R.id.back_fragment))
        cardItems.add(CardItem("Ноги",  R.drawable.b_5, R.id.legs_fragment))
        cardItems.add(CardItem("Плечи",  R.drawable.b_6, R.id.shoulders_fragment))
        return cardItems
    }
}