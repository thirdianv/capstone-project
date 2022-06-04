package com.bangkit2022.bentala.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2022.bentala.R
import com.bangkit2022.bentala.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}