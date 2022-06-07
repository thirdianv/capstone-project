package com.bangkit2022.bentala.view.onboard


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2022.bentala.databinding.ActivitySecondBinding
import com.bangkit2022.bentala.view.MainActivity


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLanjut2.setOnClickListener {
            callThirdActivity()
        }

        binding.btnSkip2.setOnClickListener {
            callMainActivity()
        }

    }

    private fun callThirdActivity(){
        startActivity(Intent(this, ThirdActivity::class.java))
        finish()
    }
    private fun callMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}