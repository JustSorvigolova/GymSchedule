package com.example.gymschedule
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.databinding.FragmentTricepcBinding


class Fragment_Tricepc : Fragment() {
    private var binding: FragmentTricepcBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTricepcBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }
}