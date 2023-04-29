package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.databinding.FragmentBicepcBinding

class Fragment_Bicepc : Fragment() {

    private var binding: FragmentBicepcBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBicepcBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}