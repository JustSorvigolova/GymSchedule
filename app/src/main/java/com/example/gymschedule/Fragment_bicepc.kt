package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.fragment_add
import com.example.gymschedule.databinding.FragmentBicepcBinding

class Fragment_bicepc : Fragment() {

    private var binding: FragmentBicepcBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBicepcBinding.inflate(LayoutInflater.from(context), container, false)

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = fragment_add()
            parentFragmentManager.beginTransaction()
                .replace(R.id.biceps_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
        return binding!!.root
    }


}