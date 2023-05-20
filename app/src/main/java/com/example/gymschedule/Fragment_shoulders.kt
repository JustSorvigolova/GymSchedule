package com.example.gymschedule
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gymschedule.Forms.Fragment_Add_Shoulders
import com.example.gymschedule.databinding.FragmentShouldersBinding

class Fragment_shoulders : Fragment() {

    private var binding: FragmentShouldersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShouldersBinding.inflate(LayoutInflater.from(context), container, false)
        binding!!.floatingActionButton.setOnClickListener {
            val fragment = Fragment_Add_Shoulders()
            parentFragmentManager.beginTransaction()
                .replace(R.id.shoulders_fragment, fragment)
                .addToBackStack(null)
                .commit()
            binding!!.floatingActionButton.visibility = View.GONE
        }
        return binding!!.root
    }

}