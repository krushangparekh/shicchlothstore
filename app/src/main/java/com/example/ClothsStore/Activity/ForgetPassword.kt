package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ClothsStore.userModel.forgetResponsemodel
import com.example.ClothsStore.userModel.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgetPassword : AppCompatActivity() {
    private lateinit var buttonnext: Button
    private lateinit var ETEmailedittext: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        buttonnext = findViewById(R.id.buttonnext)
        ETEmailedittext = findViewById(R.id.ETEmailedittext)

        buttonnext.setOnClickListener {

            if (TextUtils.isEmpty(ETEmailedittext.toString())) {
                ETEmailedittext.error = "Please enter your email address"
                return@setOnClickListener
            }
            if (Patterns.EMAIL_ADDRESS.matcher(ETEmailedittext.toString()).matches()) {
                ETEmailedittext.error = "Please enter a valid email address"
                return@setOnClickListener
            }

            val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
            retIn.loginResponsemodel(ETEmailedittext.text.toString())
                .enqueue(object : Callback<forgetResponsemodel> {

                    override fun onFailure(call: Call<forgetResponsemodel>, t: Throwable) {
                        Log.e("Data 2:::", "t.message:::" + t.message)
                        Toast.makeText(this@ForgetPassword, t.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<forgetResponsemodel>,
                        response: Response<forgetResponsemodel>
                    ) {
                        Log.e("Data 2:::", "response:::" + response.body())
                        //progressBar.visibility = View.GONE

                        ///Intent///
                        startActivity(Intent(this@ForgetPassword, Login::class.java))


                        Toast.makeText(
                            applicationContext,
                            "ForgetPassword successful!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })
        }
    }
}


