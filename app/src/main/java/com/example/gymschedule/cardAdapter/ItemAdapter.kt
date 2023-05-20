package com.example.gymschedule.cardAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymschedule.Data.Data_Card
import com.example.gymschedule.databinding.ItemDataDownBinding


class ItemAdapter(private var itemList: List<Data_Card>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val binding: ItemDataDownBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data_Card) {
            binding.title.text = item.title
            binding.desc.text = item.desc

            // Загрузка изображения с использованием библиотеки Glide
            Glide.with(binding.imageView)
                .load(item.imageURL)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDataDownBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setItemList(newItemList: List<Data_Card>) {
        itemList = newItemList
    }
}