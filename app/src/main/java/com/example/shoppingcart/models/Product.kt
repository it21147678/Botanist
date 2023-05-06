package com.example.shoppingcart.models

import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import java.util.Objects

data class Product(
    var id: String,
    var name: String,
    var price: Double,
    var isAvailable: Boolean,
    var imageUrl: String
) {
    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }

        @BindingAdapter("android:productImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(imageView)
                    .load(it)
                    .fitCenter()
                    .into(imageView)
            }
        }
    }
}
