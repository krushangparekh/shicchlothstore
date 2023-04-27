package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.DATABASE.DatabaseHelper
import com.example.ClothsStore.DATABASE.Product
import com.example.ClothsStore.ViewAdapter.AddToCartRecyclerViewAdapter
import com.google.gson.Gson

class My_Cart : AppCompatActivity() {


    var arrayList: ArrayList<productListModel> = ArrayList()
    private lateinit var buy_nowcart: TextView
    val AddToCartRecyclerViewAdapter: AddToCartRecyclerViewAdapter? = null
    var recyclerView: RecyclerView? = null

    val dbHelper = DatabaseHelper(this)
    val cartItems: ArrayList<Product> = dbHelper.getCartItems()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_cart)
        initilization()

        val dbHelper = DatabaseHelper(this)
//        dbHelper.getCartItems()
        var cursor: ArrayList<Product> = dbHelper.getCartItems()
        Log.e("cart Data", Gson().toJson(dbHelper.getCartItems()).toString())
        buy_nowcart = findViewById(R.id.buy_nowcart)
        val gridLayoutManager = GridLayoutManager(this, 1)
        val AddToCartRecyclerViewAdapter = AddToCartRecyclerViewAdapter(this@My_Cart, arrayList)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.apply {
            adapter = AddToCartRecyclerViewAdapter
        }
        buy_nowcart.setOnClickListener {

            val intent = Intent(this@My_Cart, AddAddressPage::class.java)
            startActivity(intent)
        }
               /* val ordarRecyclerviewAdapter = OrdarRecyclerviewAdapter(this@My_Cart, arrayList)
        recyclerView?.apply {
            adapter = ordarRecyclerviewAdapter
        }*/
       /* @SuppressLint("SetTextI18n")
        fun onResponse(
            call: Call<ProductDetailedModel1>,
            response: Response<ProductDetailedModel1>
        ) {
            val response = response.body()?.data
            //            IVcartimage.text = response?.title
            //     currentrs.text = response?.variants?.get(0)?.price
        }*/
    }
        private fun initilization() {
        recyclerView = findViewById(R.id.cart_recycler)
    }
}






