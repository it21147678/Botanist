package com.example.shoppingcart.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppingcart.models.Product
import java.util.*

class ShopRepo {

    private var mutableProductList: MutableLiveData<List<Product>>? = null

    fun getProducts(): LiveData<List<Product>> {
        if (mutableProductList == null) {
            mutableProductList = MutableLiveData()
            loadProducts()
        }
        return mutableProductList!!
    }

    private fun loadProducts() {
        val productList = ArrayList<Product>()
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Pachira Plant | පැචිර",
                1299,
                true,
                "https://www.ceylonagri.lk/wp-content/webpc-passthru.php?src=https://www.ceylonagri.lk/wp-content/uploads/2023/03/Untitled-design-12.jpg&nocache=1"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Red Custard Apple | රතු සීනි අනෝදා",
                799,
                true,
                "https://www.ceylonagri.lk/wp-content/webpc-passthru.php?src=https://www.ceylonagri.lk/wp-content/uploads/2023/03/Untitled-design-4.jpg&nocache=1"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Thai Mulberry | තායි මල්බෙරි",
                999,
                true,
                "https://www.ceylonagri.lk/wp-content/uploads/2023/02/Untitled-design-11.jpg"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Malaysian Seedless Jack fruit | බීජ රහිත කොස්",
                699,
                false,
                " https://www.ceylonagri.lk/wp-content/uploads/2023/02/Untitled-design-17.jpg"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Ceylon Red Guava | දේශීය රතු පේර",
                999,
                true,
                "https://www.ceylonagri.lk/wp-content/webpc-passthru.php?src=https://www.ceylonagri.lk/wp-content/uploads/2023/03/Untitled-design-20.jpg&nocache=1"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                " Hawai Guava | හවායි පේර",
                1099,
                true,
                "https://www.ceylonagri.lk/wp-content/webpc-passthru.php?src=https://www.ceylonagri.lk/wp-content/uploads/2023/04/hawai-pera.jpg&nocache=1"
            )
        )
        productList.add(
            Product(
                UUID.randomUUID().toString(),
                "Bangkok Custard Apple | බැංකොක් සීනි අනෝදා",
                399,
                true,
                "https://www.ceylonagri.lk/wp-content
