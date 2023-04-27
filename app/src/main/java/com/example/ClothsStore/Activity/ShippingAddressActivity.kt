package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class ShippingAddressActivity : AppCompatActivity() {
    private var etFirstName: EditText? = null
    private var etLastName: EditText? = null
    private var etAddressLine1: EditText? = null
    private var etAddressLine2: EditText? = null
    private var etCity: EditText? = null
    private var etState: EditText? = null
    private var etCountry: EditText? = null
    private var btnSubmit: Button? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)


        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etAddressLine1 = findViewById(R.id.etAddressLine1)
        etAddressLine2 = findViewById(R.id.etAddressLine2)
        etCity = findViewById(R.id.etCity)
        etState = findViewById(R.id.etState)
        etCountry = findViewById(R.id.etCountry)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Create a LinearLayout as the root layout
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayout.layoutParams = layoutParams

        // Create EditText views for each field in the shipping address form
        etFirstName = createEditText(this, "First Name")
        etLastName = createEditText(this, "Last Name")
        etAddressLine1 = createEditText(this, "Address Line 1")
        etAddressLine2 = createEditText(this, "Address Line 2")
        etCity = createEditText(this, "City")
        etState = createEditText(this, "State")
        etCountry = createEditText(this, "Country")

        // Create a Button for form submission
        btnSubmit = Button(this)
        btnSubmit!!.text = "Submit"
        btnSubmit!!.setOnClickListener { view: View? -> onSubmitClicked() }

        // Add the EditText views and Button to the LinearLayout
        linearLayout.addView(etFirstName)
        linearLayout.addView(etLastName)
        linearLayout.addView(etAddressLine1)
        linearLayout.addView(etAddressLine2)
        linearLayout.addView(etCity)
        linearLayout.addView(etState)
        linearLayout.addView(etCountry)
        linearLayout.addView(btnSubmit)

        // Set the LinearLayout as the content view
        setContentView(linearLayout)
    }

    // Helper method to create an EditText view with a hint
    private fun createEditText(context: Context, hint: String): EditText {
        val editText = EditText(context)
        editText.hint = hint
        editText.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return editText
    }

    // Method to handle form submission
    private fun onSubmitClicked() {
        // Retrieve the values entered in the EditText views
        val firstName = etFirstName!!.text.toString()
        val lastName = etLastName!!.text.toString()
        val addressLine1 = etAddressLine1!!.text.toString()
        val addressLine2 = etAddressLine2!!.text.toString()
        val city = etCity!!.text.toString()
        val state = etState!!.text.toString()
        val country = etCountry!!.text.toString()

        // Perform validation as needed, and proceed with submitting the form data
        // You can customize the validation logic and form submission as per your requirements
    }
}
