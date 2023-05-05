package com.example.ClothsStore.ViewAdapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.My_Cart
import com.example.ClothsStore.R
import com.example.ClothsStore.`interface`.RemoveCartCallback
import com.example.ClothsStore.activity.Product
import com.example.ClothsStore.database.DatabaseHelper
import com.squareup.picasso.Picasso

class AddToCartAdapter(
    var context: Context,
    private val Addtocartlist: ArrayList<Product>, myCart: My_Cart) : RecyclerView.Adapter<AddToCartAdapter.ViewHolder>(),
    RemoveCartCallback {
    var positionToRemove = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val listItem: View = layoutInflater.inflate(R.layout.mycard_item, parent, false)
        return ViewHolder(listItem)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currentname.text = Addtocartlist[position].name
        holder.currentRs.text =Addtocartlist[position].price
        holder.TVcurrent_size.text =Addtocartlist[position].size
        holder.TVcurrent_color.text =Addtocartlist[position].color

//        Log.e("Datasssss:::", "Datasss:::" + Addtocartlist[position].toString())
        Picasso.get().load(Addtocartlist[position].imageUrl).into(holder.IVcartimage)

        holder.selectremove.setOnClickListener { view ->
            positionToRemove = position
            val dbHelper = DatabaseHelper(context as Activity)     // activity mathi data add krva mate
            dbHelper.removeFromCart(Addtocartlist[position].id, this)
        }
    }

    override fun getItemCount(): Int {
        return if (Addtocartlist.isNotEmpty()) Addtocartlist.size else 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var IVcartimage: ImageView = itemView.findViewById<View>(R.id.IVcartimage) as ImageView
        var currentname: TextView = itemView.findViewById<View>(R.id.currentname) as TextView
        var currentRs: TextView = itemView.findViewById<View>(R.id.currentRs) as TextView
        var TVcurrent_size: TextView = itemView.findViewById<View>(R.id.TVcurrent_size) as TextView
        var TVcurrent_color: TextView = itemView.findViewById<View>(R.id.TVcurrent_color) as TextView
        var selectremove: ImageView = itemView.findViewById<View>(R.id.selectremove) as ImageView

        var mycartitemview: CardView =
            itemView.findViewById<View>(R.id.mycartitemview) as CardView
    }

    override fun onRemoveCartSuccess() {
        Addtocartlist.remove(Addtocartlist[positionToRemove])
        Toast.makeText(context,"Successfully removed from cart",Toast.LENGTH_SHORT).show()
        notifyDataSetChanged()
    }

    override fun onRemoveCartFailure() {
       (context as Activity).runOnUiThread {
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
       }
    }

}
