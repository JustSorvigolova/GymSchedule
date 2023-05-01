package com.example.gymschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.databinding.FragmentMyWorkoutBinding


class fragment_my_workout : Fragment() {
    private var binding: FragmentMyWorkoutBinding? = null
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyWorkoutBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}