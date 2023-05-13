package com.example.app_lab002

//import com.google.firebase.database.core.view.View
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val context:android.content.Context,private var dataList:List<DataClass>):RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(context).load(dataList[position].dataImage).into(holder.recImage)
        holder.recTitle.text = dataList[position].dataTitle
        holder.recDesc.text = dataList[position].dataDesc
        holder.recPrice.text = dataList[position].dataPrice
        holder.recPriority.text = dataList[position].dataPriority

        holder.recCard.setOnClickListener{
            val intent = Intent(context,DetailActivity1::class.java)
            intent.putExtra("Image",dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Title",dataList[holder.adapterPosition].dataTitle)
            intent.putExtra("Priority",dataList[holder.adapterPosition].dataPriority)
            intent.putExtra("Price",dataList[holder.adapterPosition].dataPrice)
            intent.putExtra("Description",dataList[holder.adapterPosition].dataDesc)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: List<DataClass>){
        dataList = searchList
        notifyDataSetChanged()

    }

}

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var recImage: ImageView
    var recTitle: TextView
    var recPriority: TextView
    var recPrice: TextView
    var recDesc: TextView
    var recCard:CardView

    init{
        recImage = itemView.findViewById(R.id.recImage1)
        recTitle = itemView.findViewById(R.id.recTitle1)
        recPriority = itemView.findViewById(R.id.recPriority1)
        recPrice = itemView.findViewById(R.id.recPrice1)
        recDesc = itemView.findViewById(R.id.recDesc1)
        recCard = itemView.findViewById(R.id.recCard1)
    }

}