package com.example.gymschedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymschedule.ViewModels.LegsViewModel
import com.example.gymschedule.Forms.Fragment_Add_Legs
import com.example.gymschedule.cardAdapter.ItemAdapter
import com.example.gymschedule.databinding.FragmentLegsBinding

class Fragment_legs : Fragment() {

    private var binding: FragmentLegsBinding? = null
    private lateinit var itemViewModel: LegsViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLegsBinding.inflate(inflater, container, false)

        return binding!!.root
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ItemAdapter(emptyList())
        binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }

        itemViewModel = ViewModelProvider(this)[LegsViewModel::class.java]
        itemViewModel.loadData()

        itemViewModel.getItemList().observe(viewLifecycleOwner) { itemList ->
            itemAdapter.setItemList(itemList)
            itemAdapter.notifyDataSetChanged()
        }
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Legs()
            parentFragmentManager.beginTransaction()
                .replace(R.id.legs_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
            binding!!.recyclerView.visibility = View.GONE
        }


    }

}