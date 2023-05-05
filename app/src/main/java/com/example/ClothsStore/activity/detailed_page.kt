package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.ClothsStore.ViewAdapter.MyCustomPagerAdapter
import com.example.ClothsStore.ViewAdapter.ProductDetailedModel1
import com.example.ClothsStore.activity.Buy_now_Activity
import com.example.ClothsStore.database.DatabaseHelper
import com.google.android.gms.analytics.ecommerce.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("UNUSED_EXPRESSION")
class detailed_page : AppCompatActivity() {
    private lateinit var add_to_cart_button: Button
    private lateinit var buy_now_button: Button
    private lateinit var viewPager: ViewPager
    private lateinit var TVproductname: TextView
    private lateinit var detailed_price: TextView
    private lateinit var detailed_textview: TextView
    private lateinit var tvcolorch: TextView
    private lateinit var numberInput: TextView
    private lateinit var minusButton: Button
    private lateinit var plusButton: Button
    private lateinit var myLayoutId: LinearLayout
    private lateinit var progressBar2: ProgressBar
    var recyclerView: RecyclerView? = null
    val valueList: ArrayList<String> = ArrayList()
    val ImagesList: ArrayList<String> = ArrayList()
    val colorList: ArrayList<String> = ArrayList()
    val Products: ArrayList<Product> = ArrayList()

    var myCustomPagerAdapter: MyCustomPagerAdapter? = null

    var getProductName: String? = null
    var getProductRS: String? = null
    var getProductSize: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_page)


        add_to_cart_button = findViewById(R.id.add_to_cart_button)
        buy_now_button = findViewById(R.id.buy_now_button)

        viewPager = findViewById(R.id.viewPager)

        TVproductname = findViewById(R.id.TVproductname)
        detailed_price = findViewById(R.id.detailed_price)
        detailed_textview = findViewById(R.id.detailed_textview)
        myLayoutId = findViewById(R.id.myLayoutId)
        progressBar2 = findViewById(R.id.progressBar2)
        tvcolorch = findViewById(R.id.tvcolorch)
        numberInput = findViewById(R.id.number_input)
        minusButton = findViewById(R.id.minus_button)
        plusButton = findViewById(R.id.plus_button)
        val myValue = intent.getStringExtra("id")


        add_to_cart_button.setOnClickListener {
            Log.e("PRODUCT_NAME=======", getProductName.toString())
            Log.e("PRODUCT_$$$$", getProductRS.toString())

            val dbHelper = DatabaseHelper(this)
            dbHelper.addToCart(
                name = getProductName!!,
                price = getProductRS!!,
                size = getProductSize!!,
                imageUrl = ImagesList.get(0),
                color = colorList[0],
                style = null
            )

            val intent = Intent(this@detailed_page, My_Cart::class.java)
            startActivity(intent)
        }

        /* // Create a list of image URLs
         List<String> imageUrls = new ArrayList<>();
         imageUrls.add("https://example.com/image1.jpg");
         imageUrls.add("https://example.com/image2.jpg");
         image*/

        /////////////api////////////
        progressBar2.visibility = View.VISIBLE
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        if (myValue != null) {
            retIn.ProductDetailed(myValue).enqueue(object : Callback<ProductDetailedModel1> {
                override fun onFailure(call: Call<ProductDetailedModel1>, t: Throwable) {
                    Log.v("DONE:::", "t.message:::" + t.message)
                }

                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<ProductDetailedModel1>, response: Response<ProductDetailedModel1>
                ) {
                    progressBar2.visibility = View.GONE

                    val response = response.body()?.data
                    TVproductname.text = response?.title
                    detailed_price.text =
                        response?.variants?.get(0)?.price   //array in variants and get thi position set thay price ne
                    TVproductname.text = response?.title

                    /////////add to cart ////////data send//////////
                    getProductName = response?.title
                    getProductRS = response?.variants?.get(0)?.price
                    getProductSize = response?.variants?.get(0)?.option1

                    tvcolorch.text = (response!!.variants[0].option2 + "")
                    detailed_textview.text = Html.fromHtml(response.body_html)

                    /////for color mate try kruyou che-> on
                    for (j in 0 until response.variants.size) {
                        colorList.add(response.variants[j].option2 + "")
                    }
                    ///stop
                    ///size
                    for (j in 0 until response.variants.size) {
                        valueList.add(response.variants[j].option1.toString())
                    }
                    for (i in 0 until valueList.size) {
                        val tv = TextView(this@detailed_page)
                        tv.text = valueList[i]
                        tv.textSize = 15f
                        tv.setPadding(30, 10, 30, 10)
                        tv.id = i
                        tv.setTextColor(Color.BLACK)
                        tv.setBackgroundResource(R.drawable.unselectedproductunitlayout)
                        tv.setTypeface(tv.typeface, Typeface.BOLD)
                        tv.setOnClickListener { view ->
                            changeState(view.id)
                        }
                        val lp = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        lp.setMargins(15, 0, 15, 0)
                        tv.layoutParams = lp
                        myLayoutId.addView(tv)
                    }
                    for (j in 0 until response.images.size) {
                        val Image = response.images.size

                        ImagesList.add(response.images[j].src)
                    }
                    myCustomPagerAdapter = MyCustomPagerAdapter(this@detailed_page, ImagesList)
                    viewPager.adapter = myCustomPagerAdapter
                }
            })
        }
        minusButton.setOnClickListener {
            val currentValue = numberInput.text.toString().toInt()
            if (currentValue > 0) {
                val newValue = currentValue - 1
                numberInput.text = newValue.toString()
            }
        }
        plusButton.setOnClickListener {
            val currentValue = numberInput.text.toString().toInt()
            val newValue = currentValue + 1
            numberInput.text = newValue.toString()
        }

        buy_now_button.setOnClickListener {
            /*  val intent = Intent(Intent.ACTION_VIEW)
              intent.data = Uri.parse("https://shiv-cloths-store.myshopify.com/checkouts/c/5a27a814becbea4e27440c9eac1f6081/information")*/
//            intent.data = Uri.parse("https://shiv-cloths-store.myshopify.com/")
            val intent = Intent(this@detailed_page, Buy_now_Activity::class.java)
            startActivity(intent)
        }
    }

    private fun changeState(selectedId: Int) {
        for (i in 0 until valueList.size) {
            val textView = myLayoutId.getChildAt(i) as TextView
            if (textView.id == selectedId) {
                textView.setTextColor(Color.WHITE)
                textView.setBackgroundResource(R.drawable.selected_product_unit_layout)
            } else {
                textView.setTextColor(Color.BLACK)
                textView.setBackgroundResource(R.drawable.unselectedproductunitlayout)
            }
        }
    }
}

