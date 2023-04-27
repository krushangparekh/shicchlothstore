package com.example.ClothsStore

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SetNewPassword : AppCompatActivity() {
    private lateinit var buttonok: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setnewpassword)
        buttonok = findViewById(R.id.buttonok)

        buttonok.setOnClickListener {
            val intent = Intent(this@SetNewPassword, ForgetPasswordSuccessMSG::class.java)
            startActivity(intent)
            finish()
        }
    }




}