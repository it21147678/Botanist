package com.example.shoppingcart.models

import android.widget.Spinner
import androidx.annotation.NonNull
//import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil

class CartItem(val product: Product, var quantity: Int) {

    override fun toString(): String {
        return "CartItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}'
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val cartItem = other as CartItem
        return quantity == cartItem.quantity &&
                product == cartItem.product
    }

    companion object {

        @JvmStatic
        //@BindingAdapter("android:setVal")
        fun getSelectedSpinnerValue(spinner: Spinner, quantity: Int) {
            spinner.setSelection(quantity - 1, true)
        }

        @JvmField
        val itemCallback: DiffUtil.ItemCallback<CartItem> = object : DiffUtil.ItemCallback<CartItem>() {
            override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
                return oldItem.quantity == newItem.quantity
            }

            override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
