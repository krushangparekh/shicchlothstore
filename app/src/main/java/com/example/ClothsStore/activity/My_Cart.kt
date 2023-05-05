package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.ViewAdapter.AddToCartAdapter
import com.example.ClothsStore.activity.Buy_now_Activity
import com.example.ClothsStore.activity.Product
import com.example.ClothsStore.activity.productListModel
import com.example.ClothsStore.database.DatabaseHelper
import com.google.gson.Gson


class My_Cart : AppCompatActivity() {


    var arrayList: ArrayList<productListModel> = ArrayList()
    private lateinit var buy_nowcart: TextView
    var addToCartAdapter: AddToCartAdapter? = null
    var recyclerView: RecyclerView? = null
    private lateinit var selectremove: ImageView


//    val cartItems: ArrayList<Product> = dbHelper.getCartItems()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_cart)
        initilization()

        val dbHelper = DatabaseHelper(this)

        var cursor: ArrayList<Product> = dbHelper.getCartItems()
        Log.e("cart Data", Gson().toJson(dbHelper.getCartItems()).toString())
        buy_nowcart = findViewById(R.id.buy_nowcart)
        recyclerView = findViewById(R.id.cart_recycler)

//        arrayList = dbHelper.addToCart()
        cursor.reverse()
        addToCartAdapter = AddToCartAdapter(this, cursor, My_Cart())
        recyclerView?.adapter = addToCartAdapter

        buy_nowcart.setOnClickListener {

            val intent = Intent(this@My_Cart, Buy_now_Activity::class.java)
            startActivity(intent)
        }

    }

    private fun initilization() {
        recyclerView = findViewById(R.id.cart_recycler)
    }
}






