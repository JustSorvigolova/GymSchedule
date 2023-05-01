package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.databinding.FragmentLegsBinding
import com.example.gymschedule.databinding.FragmentShouldersBinding

class Fragment_shoulders : Fragment() {

    private var binding: FragmentShouldersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShouldersBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

}