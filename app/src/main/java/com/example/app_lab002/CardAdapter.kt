package com.example.app_lab002

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_lab002.databinding.CardCellBinding


class CardAdapter (
    private val plants:List<Plant>,
    private val clickListener: PlantClickListener
)
    :RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from,parent,false)
        return CardViewHolder(binding,clickListener)
    }

    override fun getItemCount(): Int = plants.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindproduct(plants[position])
    }
}