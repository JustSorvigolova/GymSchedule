package com.example.gymschedule
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gymschedule.ViewModelCard.CardViewModel
import com.example.gymschedule.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var cardViewModel: CardViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomView = binding.bottomNavigation

        val navController = findNavController(R.id.container)

        navController.removeOnDestinationChangedListener { _, destination, _ ->
         bottomView.visibility = if (destination.id == R.id.fragment_add) View.GONE else View.VISIBLE
        }
        bottomView.setupWithNavController(navController)
    }
    }


