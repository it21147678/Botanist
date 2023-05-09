package com.example.app_lab002

import androidx.recyclerview.widget.RecyclerView
import com.example.app_lab002.databinding.CardCellBinding

class CardViewHolder(
    private var cardCellBinding: CardCellBinding,
    private val clickListener:  PlantClickListener,

    ) :RecyclerView.ViewHolder(cardCellBinding.root)
{
     fun bindproduct( plant: Plant){
        cardCellBinding.cover.setImageResource(plant.cover)
        cardCellBinding.title.text = plant.title
        cardCellBinding.plantname.text = plant.plantname

         cardCellBinding.cardView.setOnClickListener{
             clickListener.onClick(plant)
         }
    }
}