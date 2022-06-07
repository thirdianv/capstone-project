package com.bangkit2022.bentala.view.onboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2022.bentala.databinding.ActivityMainBinding
import com.bangkit2022.bentala.databinding.ActivityOneBinding

class OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}