package com.example.mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnPaid : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPaid = findViewById(R.id.payButton)

        btnPaid.setOnClickListener{
            val intent = Intent(this, Summery::class.java)
            startActivity(intent)
        }


    }
}