package com.example.ClothsStore.ViewAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.My_Cart
import com.example.ClothsStore.R
import com.example.ClothsStore.activity.Product
import com.squareup.picasso.Picasso

class AddToCartAdapter(
    var context: Context,
    private val Addtocartlist: ArrayList<Product>, myCart: My_Cart) : RecyclerView.Adapter<AddToCartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val listItem: View = layoutInflater.inflate(R.layout.mycard_item, parent, false)
        return ViewHolder(listItem)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currentname.text = Addtocartlist[position].name
        holder.currentRs.text = "Rs. " + Addtocartlist[position].price
//        Log.e("Datasssss:::", "Datasss:::" + Addtocartlist[position].toString())
        Picasso.get().load(Addtocartlist[position].imageUrl).into(holder.IVcartimage)

        holder.mycartitemview.setOnClickListener { view ->
            // add your code here for handling click events on the item
        }
    }

    override fun getItemCount(): Int {
        return if (Addtocartlist.isNotEmpty()) Addtocartlist.size else 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var IVcartimage: ImageView = itemView.findViewById<View>(R.id.IVcartimage) as ImageView
        var currentname: TextView = itemView.findViewById<View>(R.id.currentname) as TextView
        var currentRs: TextView = itemView.findViewById<View>(R.id.currentRs) as TextView
        var mycartitemview: CardView =
            itemView.findViewById<View>(R.id.mycartitemview) as CardView
    }
}
