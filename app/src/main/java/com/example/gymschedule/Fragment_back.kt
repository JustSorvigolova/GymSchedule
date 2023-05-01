package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.databinding.FragmentAddBinding
import com.example.gymschedule.databinding.FragmentBackBinding


class Fragment_back : Fragment() {

    private var binding: FragmentBackBinding ? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBackBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }


}