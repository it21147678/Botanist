package com.example.mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Summery : AppCompatActivity() {
    private lateinit var backBtn : Button
    private lateinit var payCardBtn: Button
    private lateinit var payCashBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summery)

        backBtn = findViewById(R.id.backButton)

        backBtn.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        payCardBtn = findViewById(R.id.payWithCard)

        payCardBtn.setOnClickListener(){
            val intent = Intent(this, CreditCard::class.java)
            startActivity(intent)
        }

        payCashBtn = findViewById(R.id.cashPayment)

        payCashBtn.setOnClickListener(){
            val intent = Intent(this, SuccessFullMsg::class.java)
            startActivity(intent)
        }
    }
}