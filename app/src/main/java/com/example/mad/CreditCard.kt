package com.example.mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase

class CreditCard : AppCompatActivity() {
    private lateinit var cdPayBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)

        //val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        cdPayBtn = findViewById(R.id.creditCrdPayBtn)

        cdPayBtn.setOnClickListener(){
            val intent = Intent(this, SuccessFullMsg::class.java)
            startActivity(intent)
        }
    }
}