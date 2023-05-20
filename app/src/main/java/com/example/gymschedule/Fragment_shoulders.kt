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
import com.example.gymschedule.ViewModels.ShouldersViewModel
import com.example.gymschedule.Forms.Fragment_Add_Shoulders
import com.example.gymschedule.cardAdapter.ItemAdapter
import com.example.gymschedule.databinding.FragmentShouldersBinding

class Fragment_shoulders : Fragment() {

    private var binding: FragmentShouldersBinding? = null
    private lateinit var itemViewModel: ShouldersViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShouldersBinding.inflate(inflater, container, false)

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

        itemViewModel = ViewModelProvider(this)[ShouldersViewModel::class.java]
        itemViewModel.loadData()

        itemViewModel.getItemList().observe(viewLifecycleOwner) { itemList ->
            itemAdapter.setItemList(itemList)
            itemAdapter.notifyDataSetChanged()
        }
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Shoulders()
            parentFragmentManager.beginTransaction()
                .replace(R.id.shoulders_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
            binding!!.recyclerView.visibility = View.GONE
        }
    }

}