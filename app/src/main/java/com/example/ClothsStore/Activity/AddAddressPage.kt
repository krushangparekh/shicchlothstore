package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.ClothsStore.Activity.GooglePay

class  AddAddressPage : AppCompatActivity() {
    var etaddFirstName: EditText? = null
    var etaddLastName: EditText? = null
    var etaddAddressLine1: EditText? = null
    var etaddAddressLine2: EditText? = null
    var etaddCity: EditText? = null
    var etaddState: EditText? = null
    var etaddCountry: EditText? = null
    var etaddPINcode: EditText? = null
    var BTNContinuetopayment: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address_page)
        BTNContinuetopayment = findViewById(R.id.BTNContinuetopayment)
        etaddFirstName = findViewById(R.id.etaddFirstName)
        etaddLastName = findViewById(R.id.etaddLastName)
        etaddAddressLine1 = findViewById(R.id.etaddAddressLine1)
        etaddAddressLine2 = findViewById(R.id.etaddAddressLine2)
        etaddCity = findViewById(R.id.etaddCity)
        etaddState = findViewById(R.id.etaddState)
        etaddCountry = findViewById(R.id.etaddCountry)
        etaddPINcode = findViewById(R.id.etaddPINcode)
        BTNContinuetopayment?.setOnClickListener {

            val etaddFirstName = etaddFirstName?.text.toString()
            val etaddLastName = etaddLastName?.text.toString()
            val etaddAddressLine1 = etaddAddressLine1?.text.toString()
            val etaddAddressLine2 = etaddAddressLine2?.text.toString()
            val etaddCity = etaddCity?.text.toString()
            val etaddState = etaddState?.text.toString()
            val etaddCountry = etaddCountry?.text.toString()
            val etaddPINcode = etaddPINcode?.text.toString()
            var final_address = ""
            if (etaddFirstName.isNotEmpty()) {
                final_address += etaddFirstName
            }
            if (etaddLastName.isNotEmpty()) {
                final_address += etaddLastName
            }
            if (etaddAddressLine1.isNotEmpty()) {
                final_address += etaddAddressLine1
            }
            if (etaddAddressLine2.isNotEmpty()) {
                final_address += etaddAddressLine2
            }
            if (etaddCity.isNotEmpty()) {
                final_address += etaddCity
            }
            if (etaddState.isNotEmpty()) {
                final_address += etaddState
            }
            if (etaddCountry.isNotEmpty()) {
                final_address += etaddCountry
            }
            if (etaddPINcode.isNotEmpty()) {
                final_address += etaddPINcode
            }
            if (etaddFirstName.isNotEmpty() && etaddLastName.isNotEmpty() && etaddAddressLine1.isNotEmpty() && etaddAddressLine2.isNotEmpty()
                && etaddCity.isNotEmpty() && etaddCity.isNotEmpty() && etaddState.isNotEmpty() && etaddCountry.isNotEmpty()&& etaddPINcode.isNotEmpty())
            {
                val map: MutableMap<String, String> = HashMap()
                map["userAddress"] = final_address
            } else {
                Toast.makeText(this@AddAddressPage, "Kindly Fill All Field", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this@AddAddressPage, GooglePay::class.java)
            startActivity(intent)

        }
    }
}