package com.example.ClothsStore.ViewAdapter

import android.content.Context
import android.util.Log
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.view.ViewGroup
import android.widget.ImageView
import com.example.ClothsStore.R
import com.squareup.picasso.Picasso

class MyCustomPagerAdapter(var context: Context,  val ImagesList: ArrayList<String> = ArrayList()) : PagerAdapter() {
    var layoutInflater: LayoutInflater
    init {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getCount(): Int {
        return ImagesList.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = layoutInflater.inflate(R.layout.item, container, false)
        val imageView = itemView.findViewById<View>(R.id.imageView) as ImageView
        Log.e("imageView###", "ImagesList[position]:::" + ImagesList[position])
        Log.e("imageView###", "ImagesList.size:::" + ImagesList.size)
  //      imageView.setImageResource(ImagesList.get(position))
        Picasso.get()
            .load(ImagesList.get(position))
            .into(imageView);
        container.addView(itemView)

        //listening to image click
       /* imageView.setOnClickListener {
            Toast.makeText(
                context,
                "you clicked image " + (position + 1),
                Toast.LENGTH_LONG
            ).show()
        }*/
        return itemView
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}