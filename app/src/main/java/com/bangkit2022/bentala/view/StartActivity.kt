package com.bangkit2022.bentala.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Button
import com.bangkit2022.bentala.R
import com.bangkit2022.bentala.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvButtonArrowForward.setOnClickListener {
            callActivity()
        }

    }
    private fun callActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}

