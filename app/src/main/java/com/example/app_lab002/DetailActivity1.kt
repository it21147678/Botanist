package com.example.app_lab002

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.app_lab002.databinding.ActivityDetail1Binding

class DetailActivity1 : AppCompatActivity() {

    var imageURL = ""
    private lateinit var binding: ActivityDetail1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if(bundle != null){
            binding.detaildesc1.text =bundle.getString("Description")
            binding.detailTitle1.text =bundle.getString("Title")
            binding.detailpriority1.text =bundle.getString("Priority")
            binding.detailprice1.text =bundle.getString("Price")
            imageURL=bundle.getString("Image")!!
            Glide.with(this).load(bundle.getString("Image")).into(binding.detailImage1)
        }

        val forbutton =findViewById<Button>(R.id.deletedata)
        forbutton.setOnClickListener{
           val Intent = Intent(this,UploadActivity::class.java)
            startActivity(Intent)
        }
    }
}