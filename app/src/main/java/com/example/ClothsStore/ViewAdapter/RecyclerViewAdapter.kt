package com.example.ClothsStore.ViewAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.R
import com.example.ClothsStore.activity.Datas
import com.example.ClothsStore.detailed_page
import com.squareup.picasso.Picasso


class RecyclerViewAdapter(var context: Context, private val dataList: ArrayList<Datas>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.recyclerview_row, parent, false)
        return ViewHolder(listItem)
    }

    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*dataList[0].data.get(position).handle
        Log.d("Data:::","position:::"+position)*/


        holder.title.text = dataList[position].title
        holder.price.text = "Rs. " + dataList[position].variants.get(0).price

        Picasso.get()
            .load(dataList[position].image.src)
            .into(holder.rvproductimageurl);

//        Log.d("url:::","url:::"+dataList[0].data[position].image.src)
        holder.relativeLayoutitem.setOnClickListener { view ->

/*//            Log.e("title","title:::"+dataList[0].data[position].title)
//            Log.e("price","price::::::"+"Rs. " + dataList[0].data[position].variants.get(0).price)
//            Log.e("id","id:::"+dataList[0].data[position].id)
//            Log.e("variants","variants:::"+dataList[0].data[position].variants)
//            Log.e("image_id","image_id:::"+dataList[0].data[position].image)
//            Log.e("product_type","product_type:::"+dataList[0].data[position].product_type)*/

            val intent = Intent(context, detailed_page::class.java)
            intent.putExtra("id",""+dataList[position].id)
            intent.putExtra("DataObj",dataList[position])
              context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return if(dataList.isNotEmpty()) dataList.size
        else 0
//        Log.e("size===",dataList.size.toString())
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
