package com.example.shoppingcart.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingcart.models.CartItem
import com.example.shoppingcart.models.Product
import com.example.shoppingcart.repositories.CartRepo
import com.example.shoppingcart.repositories.ShopRepo

class ShopViewModel : ViewModel() {

    private val shopRepo = ShopRepo()
    private val cartRepo = CartRepo()

    private val _mutableProduct = MutableLiveData<Product>()
    val mutableProduct: LiveData<Product>
        get() = _mutableProduct

    fun getProducts(): LiveData<List<Product>> {
        return shopRepo.getProducts()
    }

    fun setProduct(product: Product) {
        _mutableProduct.value = product
    }

    fun getProduct(): LiveData<Product> {
        return mutableProduct
    }

    fun getCart(): LiveData<List<CartItem>> {
        return cartRepo.getCart()
    }

    fun addItemToCart(product: Product): Boolean {
        return cartRepo.addItemToCart(product)
    }

    fun removeItemFromCart(cartItem: CartItem) {
        cartRepo.removeItemFromCart(cartItem)
    }

    fun changeQuantity(cartItem: CartItem, quantity: Int) {
        cartRepo.changeQuantity(cartItem, quantity)
    }

    fun getTotalPrice(): LiveData<Double> {
        return cartRepo.getTotalPrice()
    }

    fun resetCart() {
        cartRepo.initCart()
    }

}
