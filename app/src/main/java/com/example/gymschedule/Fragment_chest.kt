package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.Fragment_Add_Chest
import com.example.gymschedule.databinding.FragmentChestBinding


class Fragment_chest : Fragment() {

    private var binding: FragmentChestBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChestBinding.inflate(LayoutInflater.from(context), container, false)
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Chest()
            parentFragmentManager.beginTransaction()
                .replace(R.id.chest_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
        return binding!!.root
    }


}