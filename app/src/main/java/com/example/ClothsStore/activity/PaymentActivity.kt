package com.example.ClothsStore.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.ClothsStore.R

class PaymentActivity : AppCompatActivity() {
    var add_PaymentDetailed: Toolbar? = null
    var subTotal: TextView? = null
    var discount: TextView? = null
    var shipping: TextView? = null
    var total: TextView? = null
    var paymentBtn: Button? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        //Toolbar
        setSupportActionBar(add_PaymentDetailed)
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var amount = 0.0
        amount = intent.getDoubleExtra("amount", 0.0)
        subTotal = findViewById(R.id.sub_total)
        discount = findViewById(R.id.textView17)
        shipping = findViewById(R.id.textView18)
        total = findViewById(R.id.total_amt)
        paymentBtn = findViewById(R.id.pay_btn)
        subTotal?.setText("₹ $amount")
        paymentBtn?.setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext, GooglePay::class.java))
            finish()
        })
    }

}