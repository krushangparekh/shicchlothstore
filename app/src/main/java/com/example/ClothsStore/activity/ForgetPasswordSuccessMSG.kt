package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ForgetPasswordSuccessMSG : AppCompatActivity() {
    private lateinit var loginbutton: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgetpasswordsuccessmsg)
        loginbutton = findViewById(R.id.loginbutton)

        loginbutton.setOnClickListener {
            val intent = Intent(this@ForgetPasswordSuccessMSG, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}