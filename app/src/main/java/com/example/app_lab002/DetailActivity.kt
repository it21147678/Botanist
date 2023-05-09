package com.example.app_lab002

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app_lab002.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plantId = intent.getIntExtra(PLANT_ID_EXTRA,-1)
        val plant = plantFromID(plantId)

        if(plant != null){
            binding.cover.setImageResource(plant.cover)
            binding.title.text = plant.title
            binding.description.text = plant.description
            binding.plantname.text = plant.plantname
        }
    }

    private fun plantFromID(plantId: Int):Plant?
    {
        for (plant in plantList){
            if(plant.id == plantId )
                return plant
        }
        return null
    }
}