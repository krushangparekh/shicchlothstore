package com.example.ClothsStore.Activity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ClothsStore.R
import java.util.*

class GooglePay : AppCompatActivity() {
    var amount: EditText? = null
    var note: EditText? = null
    var name: EditText? = null
    var upivirtualid: EditText? = null
    var send: Button? = null
    val UPI_PAYMENT = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.googlepay)


        send = findViewById<View>(R.id.send) as Button
        amount = findViewById<View>(R.id.amount_et) as EditText
        note = findViewById<View>(R.id.note) as EditText
        name = findViewById<View>(R.id.name) as EditText
        upivirtualid = findViewById<View>(R.id.upi_id) as EditText
        send!!.setOnClickListener { //Getting the values from the EditTexts
            if (TextUtils.isEmpty(name!!.text.toString().trim { it <= ' ' })) {
                Toast.makeText(this@GooglePay, " Name is invalid", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(upivirtualid!!.text.toString().trim { it <= ' ' })) {
                Toast.makeText(this@GooglePay, " UPI ID is invalid", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(note!!.text.toString().trim { it <= ' ' })) {
                Toast.makeText(this@GooglePay, " Note is invalid", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(amount!!.text.toString().trim { it <= ' ' })) {
                Toast.makeText(this@GooglePay, " Amount is invalid", Toast.LENGTH_SHORT).show()
            } else {
                payUsingUpi(
                    name!!.text.toString(), upivirtualid!!.text.toString(),
                    note!!.text.toString(), amount!!.text.toString()
                )
            }
        }
    }
    fun payUsingUpi(name: String, upiId: String, note: String, amount: String) {
        Log.e("main ", "name $name--up--$upiId--$note--$amount")
        val uri = Uri.parse("upi://pay").buildUpon()
            .appendQueryParameter("pa", upiId)
            .appendQueryParameter("pn", name)
            //.appendQueryParameter("mc", "")
            //.appendQueryParameter("tid", "02125412")
            //.appendQueryParameter("tr", "25584584")
            .appendQueryParameter("tn", note)
            .appendQueryParameter("am", amount)
            .appendQueryParameter("cu", "INR")
            //.appendQueryParameter("refUrl", "blueapp")
            .build()
        val upiPayIntent = Intent(Intent.ACTION_VIEW)
        upiPayIntent.data = uri

        // will always show a dialog to user to choose an app
        val chooser = Intent.createChooser(upiPayIntent, "Pay with")

        // check if intent resolves
        if (null != chooser.resolveActivity(packageManager)) {
            startActivityForResult(chooser, UPI_PAYMENT)
        } else {
            Toast.makeText(
                this@GooglePay,
                "No UPI app found, please install one to continue",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("main ", "response $resultCode")
        when (requestCode) {
            UPI_PAYMENT -> if (RESULT_OK == resultCode || resultCode == 11) {
                if (data != null) {
                    val trxt = data.getStringExtra("response")
                    Log.e("UPI", "onActivityResult: $trxt")
                    val dataList = java.util.ArrayList<String?>()
                    dataList.add(trxt)
                    upiPaymentDataOperation(dataList)
                } else {
                    Log.e("UPI", "onActivityResult: " + "Return data is null")
                    val dataList = java.util.ArrayList<String?>()
                    dataList.add("nothing")
                    upiPaymentDataOperation(dataList)
                }
            } else {
                //when user simply back without payment
                Log.e("UPI", "onActivityResult: " + "Return data is null")
                val dataList = java.util.ArrayList<String?>()
                dataList.add("nothing")
                upiPaymentDataOperation(dataList)
            }
        }
    }

    private fun upiPaymentDataOperation(data: java.util.ArrayList<String?>) {
        if (isConnectionAvailable(this@GooglePay)) {
            var str = data[0]
            Log.e("UPIPAY", "upiPaymentDataOperation: $str")
            var paymentCancel = ""
            if (str == null) str = "discard"
            var status = ""
            var approvalRefNo = ""
            val response = str.split("&".toRegex()).toTypedArray()
            for (i in response.indices) {
                val equalStr = response[i].split("=".toRegex()).toTypedArray()
                if (equalStr.size >= 2) {
                    if (equalStr[0].lowercase(Locale.getDefault()) == "Status".lowercase(Locale.getDefault())) {
                        status = equalStr[1].lowercase(Locale.getDefault())
                    } else if (equalStr[0].lowercase(Locale.getDefault()) == "ApprovalRefNo".lowercase(
                            Locale.getDefault()
                        ) || equalStr[0].lowercase(Locale.getDefault()) == "txnRef".lowercase(Locale.getDefault())
                    ) {
                        approvalRefNo = equalStr[1]
                    }
                } else {
                    paymentCancel = "Payment cancelled by user."
                }
            }
            if (status == "success") {
                //Code to handle successful transaction here.
                Toast.makeText(this@GooglePay, "Transaction successful.", Toast.LENGTH_SHORT).show()
                Log.e("UPI", "payment successfull: $approvalRefNo")
            } else if ("Payment cancelled by user." == paymentCancel) {
                Toast.makeText(this@GooglePay, "Payment cancelled by user.", Toast.LENGTH_SHORT)
                    .show()
                Log.e("UPI", "Cancelled by user: $approvalRefNo")
            } else {
                Toast.makeText(
                    this@GooglePay,
                    "Transaction failed.Please try again",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("UPI", "failed payment: $approvalRefNo")
            }
        } else {
            Log.e("UPI", "Internet issue: ")
            Toast.makeText(
                this@GooglePay,
                "Internet connection is not available. Please check and try again",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        fun isConnectionAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val netInfo = connectivityManager.activeNetworkInfo
                if (netInfo != null && netInfo.isConnected
                    && netInfo.isConnectedOrConnecting
                    && netInfo.isAvailable
                ) {
                    return true
                }
            }
            return false
        }
    }
}
