package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ClothsStore.UI.MyProfileFragment
import com.example.ClothsStore.ViewAdapter.RecyclerViewAdapter
import com.example.ClothsStore.activity.Datas
import com.example.ClothsStore.activity.My_Order
import com.example.ClothsStore.activity.Navigation_bar
import com.example.ClothsStore.activity.productListModel
import com.google.android.material.navigation.NavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home_page : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var arrayList: ArrayList<Datas> = ArrayList()
    val recyclerViewAdapter: RecyclerViewAdapter? = null
    var recyclerView: RecyclerView? = null

    private lateinit var btnlogout: ImageButton
    private lateinit var PBprogressBar: ProgressBar
    private lateinit var IBaddtocart: ImageButton
    private lateinit var drawer_imgBTN: ImageButton
    private lateinit var drawer : DrawerLayout
    private lateinit var navigationView : NavigationView
    private lateinit var hedarshopnow : Button
    private lateinit var relMain : RelativeLayout
    private lateinit var frmContainer : FragmentContainerView

    @SuppressLint("MissingInflatedId", "ApplySharedPref", "RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        initilization()
        val textvshivclothhedar: TextView = findViewById(R.id.textvshivclothhedar)
        hedarshopnow = findViewById(R.id.hedarshopnow)
        navigationView = findViewById(R.id.navigationView)
        btnlogout = findViewById(R.id.btnlogout)
        PBprogressBar = findViewById(R.id.PBprogressBar)
        IBaddtocart = findViewById(R.id.IBaddtocart)
        drawer_imgBTN = findViewById(R.id.drawer_imgBTN)
        relMain = findViewById(R.id.relMain)
        frmContainer = findViewById(R.id.frmContainer)
        drawer = findViewById(R.id.drawer)

        drawer_imgBTN.setOnClickListener{
            if (drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START)
            } else{
                drawer.openDrawer(GravityCompat.START)
            }
        }
        ///navigationView item
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    relMain.visibility = View.VISIBLE
                    frmContainer.visibility =View.GONE
                    Toast.makeText(this, "My Home", Toast.LENGTH_SHORT).show()
                    drawer.closeDrawer(GravityCompat.START)
                    val intent = Intent(this@Home_page, Home_page::class.java)
                    true

                }
                R.id.nav_profile -> {
                    relMain.visibility = View.GONE
                    frmContainer.visibility =View.VISIBLE
                    drawer.closeDrawer(GravityCompat.START)
                    val someFragment: Fragment = MyProfileFragment()
                    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction?.replace(
                        R.id.frmContainer,
                        someFragment
                    ) // give your fragment container id in first parameter
                    transaction?.addToBackStack(null) // if written, this transaction will be added to backstack
                    transaction?.commit()

                    true
                }
                R.id.nav_myorder -> {
                    relMain.visibility = View.VISIBLE
                    frmContainer.visibility =View.GONE
                    Toast.makeText(this, "My Order", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@Home_page, My_Order::class.java)
                    startActivity(intent)
                    drawer.closeDrawer(GravityCompat.START)

                    true
                }
                else -> {
                    false
                }
            }
        }
        val gridLayoutManager = GridLayoutManager(this, 2)
        val recyclerViewAdapter = RecyclerViewAdapter(this@Home_page, arrayList)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.apply {
            adapter = recyclerViewAdapter
        }

        IBaddtocart.setOnClickListener {
            val intent = Intent(this@Home_page, My_Cart::class.java)
            startActivity(intent)
        }
        textvshivclothhedar.setOnClickListener {
            val intent = Intent(this@Home_page, Home_page::class.java)
            startActivity(intent)


        }

        hedarshopnow.setOnClickListener {
//            val intent = Intent(this@Home_page, Home_page::class.java)
            val intent = Intent(this@Home_page, MyProfileFragment::class.java)
            (intent)
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
                    arrayList.addAll(response.data)
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

    override fun onBackPressed() {
        if (frmContainer.isVisible){
            frmContainer.visibility = View.GONE
            relMain.visibility = View.VISIBLE
        }
        super.onBackPressed()
    }


    private fun initilization() {
        recyclerView = findViewById(R.id.rvProductList)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

}


