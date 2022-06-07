package com.bangkit2022.bentala.view.onboard


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit2022.bentala.databinding.ActivityOneBinding
import com.bangkit2022.bentala.view.MainActivity



class OneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLanjut.setOnClickListener{
            callSecondActivity()
        }

        binding.btnSkip.setOnClickListener{
            callMainActivity()
        }

    }

    private fun callSecondActivity(){
        startActivity(Intent(this, SecondActivity::class.java))
        finish()
    }

    private fun callMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}