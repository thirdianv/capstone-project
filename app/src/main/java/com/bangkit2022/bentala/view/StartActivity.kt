package com.bangkit2022.bentala.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Button
import com.bangkit2022.bentala.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val button =findViewById<Button>(R.id.tv_button_arrow_forward)

        button.setOnClickListener {
            callActivity()
        }

    }
    private fun callActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}

