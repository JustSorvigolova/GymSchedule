package com.example.gymschedule.cardAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gymschedule.DT.CardItem
import com.example.gymschedule.R
import com.example.gymschedule.ViewModelCard.CardViewModel
import com.example.gymschedule.fragment_homeDirections


class CardAdapter(private val cardItems: List<CardItem>, private val cardViewModel:CardViewModel) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)
        return CardViewHolder(view)
    }


    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardItem = cardItems[position]
        holder.titleTextView.text = cardItem.title
        holder.imageView.setImageResource(cardItem.imageResId)
        holder.itemView.setOnClickListener {
            cardViewModel.onCardItemClick(cardItem)
            val action = when(cardItem.fragmentId) {
                R.id.biceps_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToBicepsFragment()
                }
                R.id.triceps_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToFragmentTricepc()
                }
                R.id.back_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToFragmentBack()
                }
                R.id.chest_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToFragmentChest()
                }
                R.id.legs_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToFragmentLegs()
                }
                R.id.shoulders_fragment -> {
                    fragment_homeDirections.actionFragmentHomeToFragmentShoulders()
                }
                else -> {
                    throw IllegalArgumentException("Unknown fragment ID ${cardItem.fragmentId}")
                }
            }
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return cardItems.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}

