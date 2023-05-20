package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.Fragment_Add_Back
import com.example.gymschedule.Forms.Fragment_Add_Chest
import com.example.gymschedule.databinding.FragmentAddBinding
import com.example.gymschedule.databinding.FragmentBackBinding


class Fragment_back : Fragment() {

    private var binding: FragmentBackBinding ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBackBinding.inflate(LayoutInflater.from(context), container, false)
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Back()
            parentFragmentManager.beginTransaction()
                .replace(R.id.back_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
        return binding!!.root
    }


}