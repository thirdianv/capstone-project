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
import com.bangkit2022.bentala.view.onboard.OneActivity

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler()
        handler.postDelayed({
            var intent = Intent(this@StartActivity, OneActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }

}

