package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.activity.productListModel
import com.example.ClothsStore.ViewAdapter.RecyclerViewAdapter
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home_page : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    ///////navigation bar start
//    private lateinit var drawerLayout: DrawerLayout
    private lateinit var mdrawer_layout: DrawerLayout
//    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var drawer_imgBTN: ImageButton
//    //--end---//
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navView:NavigationView

    var arrayList: ArrayList<productListModel> = ArrayList()
    val recyclerViewAdapter: RecyclerViewAdapter? = null
    var recyclerView: RecyclerView? = null

    private lateinit var btnlogout: ImageButton
    private lateinit var PBprogressBar: ProgressBar
    private lateinit var IBaddtocart: ImageButton

    @SuppressLint("MissingInflatedId", "ApplySharedPref")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        

        initilization()
        val textvshivclothhedar: TextView = findViewById(R.id.textvshivclothhedar)
        val hedarshopnow: Button = findViewById(R.id.hedarshopnow)
        btnlogout = findViewById(R.id.btnlogout)
        PBprogressBar = findViewById(R.id.PBprogressBar)
        IBaddtocart = findViewById(R.id.IBaddtocart)

        val gridLayoutManager = GridLayoutManager(this, 2)
        val recyclerViewAdapter = RecyclerViewAdapter(this@Home_page, arrayList)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.apply {
            adapter = recyclerViewAdapter
        }
        /*  drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navopen, R.string.navclose)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        //////////////////// end

        ////////////drawer_button call navigation bar
        val drawer_button = findViewById<ImageButton>(R.id.drawer_button);
        drawer_button.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }

        }*/

        IBaddtocart.setOnClickListener {
            val intent = Intent(this@Home_page, My_Cart::class.java)
            startActivity(intent)
        }
        textvshivclothhedar.setOnClickListener {
            val intent = Intent(this@Home_page, Home_page::class.java)
            startActivity(intent)
        }

        hedarshopnow.setOnClickListener {
            val intent = Intent(this@Home_page, Home_page::class.java)
            startActivity(intent)
        }
        btnlogout.setOnClickListener {
            val sharedPreference = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putBoolean("islogin", false)
            editor.commit()
            val intent = Intent(this@Home_page, Login::class.java)
            (intent)
            this.finish()
            System.exit(0)
        }

        PBprogressBar.visibility = View.VISIBLE
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        retIn.productsdata().enqueue(object : Callback<productListModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<productListModel>, response: Response<productListModel>
            ) {
                PBprogressBar.visibility = View.GONE

//                Log.e("Data 1:::", "Response Done:::" + response.body())!!
//                Log.e("Data 2:::", "Response Done:::" + response.body()!!.message)
//                Log.e("Data 3:::", "Response Done:::" + response.body()!!.data)

                val response = response.body()
                if (response != null) {
                    arrayList.addAll(listOf(response))
                    //recyclerViewAdapter.notifyDataSetChanged()
                    //                    Log.e("Data 5:::", "size:::"+arrayList.size )
                    val recyclerViewAdapter = RecyclerViewAdapter(this@Home_page, arrayList)
                    recyclerView?.layoutManager = gridLayoutManager
                    recyclerView?.apply {
                        adapter = recyclerViewAdapter
                    }
                }
            }

            override fun onFailure(call: Call<productListModel>, t: Throwable) {
//                Log.e("Data 4:::", "onFailure:::"+t.message )
            }
        })
    }

    private fun setSupportActionBar(toolbar: Toolbar) {

    }


    private fun initilization() {
        recyclerView = findViewById(R.id.rvProductList)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

}

/*class Home_page : AppCompatActivity() {

    ///////navigation bar start
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    ///--end--////

    ////////////drawer_button call navigation bar
    private lateinit var drawer_button: ImageButton
    //--end---//


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        /////////////////////navigation bar start
        drawer_button = this.findViewById(R.id.drawer_button)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.navopen, R.string.navclose)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        //////////////////// end

        ////////////drawer_button call navigation bar
        drawer_button = findViewById(R.id.drawer_button);
        drawer_button.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        //--end---//


        val myListData = arrayOf(
            MyData("11111", R.drawable.blank21),
            MyData("22222222", R.drawable.blank22),
            MyData("3333", R.drawable.blank23),
            MyData("44444", R.drawable.can1),
            MyData("55555", R.drawable.can2),
            MyData("666666", R.drawable.can3),
            MyData("777777", R.drawable.can2),
            MyData("888888", R.drawable.can3),
            MyData("11111", R.drawable.blank21),
            MyData("22222222", R.drawable.blank22),
        )
        val recyclerViewOKL = findViewById<View>(R.id.recycleView2) as RecyclerView
        val adapter = RecyclerViewAdapter(this, myListData)
        recyclerViewOKL.adapter = adapter

        val textvshivclothhedar: TextView = findViewById(R.id.textvshivclothhedar)
        textvshivclothhedar.setOnClickListener {
            val intent = Intent(this@Home_page, detailed_page::class.java)
            startActivity(intent)
            finish()
        }
        val hedarshopnow: Button = findViewById(R.id.hedarshopnow)
        hedarshopnow.setOnClickListener {
            val intent = Intent(this@Home_page, detailed_page::class.java)
            startActivity(intent)
            finish()
        }
    }
}*/
//////////api/////////
/*val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
loginBody(productsdata.toString(), productsdata.toString())

retIn.loginUser(
    productsdata.text.toString(),
    productsdata.text.toString(),
).enqueue(object : Callback<productsdata> {
    override fun onFailure(call: Call<productsdata>, t: Throwable) {
        Log.e("Data 2:::", "t.message:::" + t.message)
        Toast.makeText(this@Home_page, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<productsdata>, response: Response<productsdata>) {
        Log.e("Data 2:::", "response:::" + response.body())
    //    progressBar.visibility = View.GONE
        if (response.code() == 200) {
            ///Intent///
            startActivity(Intent(this@Home_page, Home_page::class.java))
            finish()

            Toast.makeText(
                applicationContext,
                "Login successful!",
                Toast.LENGTH_SHORT
            )
                .show()
//                                val intent = Intent(this@Login, Home_page::class.java)
//                                startActivity(intent)
//                                finish()
        } else {
            Toast.makeText(applicationContext, "Login failed!", Toast.LENGTH_SHORT)
                .show()
        }
    }
})*/


