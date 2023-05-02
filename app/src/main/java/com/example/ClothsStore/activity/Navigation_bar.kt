package com.example.ClothsStore.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ClothsStore.R
import com.google.android.material.navigation.NavigationView

class Navigation_bar : AppCompatActivity() {
    private lateinit var my_drawer_layout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarToggle: ActionBarDrawerToggle

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)
        my_drawer_layout = findViewById(R.id.my_drawer_layout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)


        actionBarToggle = ActionBarDrawerToggle(this, my_drawer_layout, toolbar, R.string.navopen, R.string.navclose)
        my_drawer_layout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

//        navigationView.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_home -> {
//                    Toast.makeText(this, "My Home", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.nav_profile -> {
//                    Toast.makeText(this, "My Profile", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.nav_myorder -> {
//                    Toast.makeText(this, "My Order", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> {
//                    false
//                }
//
//
//            }
//        }
    }
}



