package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    //Variables
    private lateinit var buttonmain: Button
    private var topAnim: Animation? = null
    private var bottomAnim: Animation? = null
    private lateinit var TVmainslogan: TextView
    lateinit var Tvmmainscrname: TextView
    lateinit var mainimageView: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  supportActionBar?.hide()
        supportActionBar?.title = "Bull's Rent"
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        //hooks
        mainimageView = findViewById(R.id.mainimageView)
        Tvmmainscrname = findViewById(R.id.Tvmmainscrname)
        TVmainslogan = findViewById(R.id.TVmainslogan)
        //button
        buttonmain = findViewById(R.id.buttonmain)
        ////anim
        Tvmmainscrname.animation = topAnim
        TVmainslogan.animation = bottomAnim
        TVmainslogan.animation = bottomAnim
        buttonmain.setOnClickListener {
           /* val sharedPreferences  = getSharedPreferences("setdata", Context.MODE_PRIVATE)
            val bool_islogin = sharedPreferences.getBoolean("islogin",false)
            Log.e("sharedPreferences--:::", "bool_islogin:::" + bool_islogin)
            if(bool_islogin){
               // intent = Intent(this@MainActivity, Home_page::class.java)

                Toast.makeText(this,"False",Toast.LENGTH_SHORT).show()
            } else {
//                intent = Intent(this@MainActivity, Login::class.java)
//                startActivity(intent)
//                finish()
            }*/
            val sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("islogin", false)
            if (isLogin) {
                runOnUiThread {
                    val intent = Intent(this,Home_page::class.java)
                    startActivity(intent)
                    this@MainActivity.finish()
                }
            } else {
                runOnUiThread {
                    val intent = Intent(this,Login::class.java)
                    startActivity(intent)
                    finish()
                }
            }
          /* val intent = Intent(this@MainActivity, Login::class.java)
           startActivity(intent)
           finish()*/
        }
    }
}

