package com.bangkit2022.bentala.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit2022.bentala.R
import com.bangkit2022.bentala.databinding.ActivityPictureProcessBinding

class PictureProcessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPictureProcessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPictureProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}