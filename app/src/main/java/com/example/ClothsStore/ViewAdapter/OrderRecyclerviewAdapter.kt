package com.example.ClothsStore.ViewAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.R
import com.example.ClothsStore.detailed_page
import com.squareup.picasso.Picasso

class OrderRecyclerviewAdapter(
    var context: Context,
    private val dataList: ArrayList<ProductDetailedModel1>
) : RecyclerView.Adapter<OrderRecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.mycard_item, parent, false)
        return ViewHolder(listItem)
    }

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onBindViewHolder(
        holder: OrderRecyclerviewAdapter.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        /*dataList[0].data.get(position).handle
        Log.d("Data:::","position:::"+position)*/


//        holder.currentdate.text = dataList[0].data.title
        holder.TVcurrent_size.text = dataList[0].data.title
        holder.TVcurrent_color.text = dataList[0].data.title
        holder.currentrs.text = "Rs. " + dataList[0].data.variants.get(0).price

        Picasso.get()
            .load(dataList[0].data.image.src)
            .into(holder.IVcartimage);


        holder.mycartitemview.setOnClickListener { view ->

            val intent = Intent(context, detailed_page::class.java)
            intent.putExtra("id", "" + dataList[0].data.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (dataList != null && dataList.size > 0) dataList.get(0).data.images.size
        else 0
        Log.e("size===============", dataList.size.toString())
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var IVcartimage: ImageView
        var tvnameitem: TextView
        var currentrs: TextView
        var TVcurrent_size: TextView
        var TVcurrent_color: TextView

        //   var product_type: TextView
        var mycartitemview: RelativeLayout

        init {
            IVcartimage = itemView.findViewById<View>(R.id.IVcartimage) as ImageView
            tvnameitem = itemView.findViewById<View>(R.id.tvnameitem) as TextView
            currentrs = itemView.findViewById<View>(R.id.currentRs) as TextView
            TVcurrent_size = itemView.findViewById<View>(R.id.TVcurrent_size) as TextView
            TVcurrent_color = itemView.findViewById<View>(R.id.TVcurrent_color) as TextView

            mycartitemview = itemView.findViewById<View>(R.id.mycartitemview) as RelativeLayout
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}