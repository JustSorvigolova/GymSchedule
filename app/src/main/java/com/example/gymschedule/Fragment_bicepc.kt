package com.example.gymschedule
import android.annotation.SuppressLint
import androidx.lifecycle.observe
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.fragment_add
import com.example.gymschedule.databinding.FragmentBicepcBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gymschedule.ViewModels.BicepsViewModel
import com.example.gymschedule.cardAdapter.ItemAdapter


class Fragment_bicepc : Fragment() {
    private var binding: FragmentBicepcBinding? = null
    private lateinit var itemViewModel: BicepsViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBicepcBinding.inflate(inflater, container, false)
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

        itemViewModel = ViewModelProvider(this)[BicepsViewModel::class.java]
        itemViewModel.loadData()

        itemViewModel.getItemList().observe(viewLifecycleOwner) { itemList ->
            itemAdapter.setItemList(itemList)
            itemAdapter.notifyDataSetChanged()
        }

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = fragment_add()
            parentFragmentManager.beginTransaction()
                .replace(R.id.biceps_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
            binding!!.recyclerView.visibility = View.GONE
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            binding = null
        }
    }
