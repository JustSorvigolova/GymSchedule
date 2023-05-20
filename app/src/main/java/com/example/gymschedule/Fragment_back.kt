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
import com.example.gymschedule.ViewModels.BackViewModel
import com.example.gymschedule.Forms.Fragment_Add_Back
import com.example.gymschedule.cardAdapter.ItemAdapter
import com.example.gymschedule.databinding.FragmentBackBinding


class Fragment_back : Fragment() {

    private var binding: FragmentBackBinding ? = null
    private lateinit var itemViewModel: BackViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBackBinding.inflate(inflater, container, false)

        return binding!!.root
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter = ItemAdapter(emptyList()) // Инициализация адаптера с пустым списком
        binding!!.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }

        itemViewModel = ViewModelProvider(this)[BackViewModel::class.java]
        itemViewModel.loadData()

        itemViewModel.getItemList().observe(viewLifecycleOwner) { itemList ->
            itemAdapter.setItemList(itemList)
            itemAdapter.notifyDataSetChanged()
        }

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Back()
            parentFragmentManager.beginTransaction()
                .replace(R.id.back_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}