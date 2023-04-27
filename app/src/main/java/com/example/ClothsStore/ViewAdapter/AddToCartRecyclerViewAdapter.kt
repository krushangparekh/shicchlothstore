package com.example.ClothsStore.ViewAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.R
import com.example.ClothsStore.productListModel
import com.squareup.picasso.Picasso

class AddToCartRecyclerViewAdapter(
    var context: Context, private val Addtocartlist: ArrayList<productListModel>
) : RecyclerView.Adapter<AddToCartRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val listItem: View = layoutInflater.inflate(R.layout.mycard_item, parent, false)
        return ViewHolder(listItem)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currentname.text = Addtocartlist[0].toString()
        holder.currentRs.text = "Rs. " + Addtocartlist[0].toString()
        Log.e("Datasssss:::", "Datasss:::" + Addtocartlist[0].toString())
        Log.e("Datasgggg:::", "Datasssss:::" + Addtocartlist[0].toString())
        Picasso.get().load(Addtocartlist[0].toString()).into(holder.IVcartimage)

        holder.mycartitemview.setOnClickListener { view ->
            // add your code here for handling click events on the item
        }
    }

    override fun getItemCount(): Int {
        return if (Addtocartlist.isNotEmpty()) itemCount.also { product -> } else 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var IVcartimage: ImageView = itemView.findViewById<View>(R.id.IVcartimage) as ImageView
        var currentname: TextView = itemView.findViewById<View>(R.id.currentname) as TextView
        var currentRs: TextView = itemView.findViewById<View>(R.id.currentRs) as TextView
        var mycartitemview: RelativeLayout =
            itemView.findViewById<View>(R.id.mycartitemview) as RelativeLayout
    }
}


/*

class AddToCartRecyclerViewAdapter(var context: Context, private val Addtocartlist: ArrayList<productListModel>) : RecyclerView.Adapter<AddToCartRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.mycard_item, parent, false)
        return RecyclerView.ViewHolder(listItem)
    }

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.title.text = Addtocartlist[0].data[position].title
        holder.price.text = "Rs. " + Addtocartlist[0].data[position].variants.get(0).price

        Picasso.get()
            .load(Addtocartlist[0].data[position].image.src)
            .into(holder.rvproductimageurl);

//        Log.d("url:::","url:::"+dataList[0].data[position].image.src)
        holder.relativeLayoutitem.setOnClickListener { view ->
       
    }

    override fun getItemCount(): Int {
        return if(Addtocartlist.size > 0) Addtocartlist.get(0).data.size
        else 0

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rvproductimageurl: ImageView
        var title: TextView
        var price: TextView
        var relativeLayoutitem: RelativeLayout

        init {
            rvproductimageurl = itemView.findViewById<View>(R.id.rvproductimageurl) as ImageView
            title = itemView.findViewById<View>(R.id.title) as TextView
            price = itemView.findViewById<View>(R.id.price) as TextView

            relativeLayoutitem = itemView.findViewById<View>(R.id.relativeLayoutitem) as RelativeLayout
        }
    } 
  }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}*/
