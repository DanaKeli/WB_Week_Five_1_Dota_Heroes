package com.example.wb_week_five_1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wb_week_five_1.R
import com.example.wb_week_five_1.databinding.ActivityMainBinding
import com.example.wb_week_five_1.presentation.heroes.HeroesVM

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.navigationBarColor = resources.getColor(R.color.black)
    }
}