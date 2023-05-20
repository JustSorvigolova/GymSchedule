package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.Fragment_Add_Chest
import com.example.gymschedule.Forms.Fragment_Add_Legs
import com.example.gymschedule.databinding.FragmentLegsBinding

class Fragment_legs : Fragment() {

    private var binding: FragmentLegsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLegsBinding.inflate(LayoutInflater.from(context), container, false)
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Legs()
            parentFragmentManager.beginTransaction()
                .replace(R.id.legs_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
        return binding!!.root
    }


}