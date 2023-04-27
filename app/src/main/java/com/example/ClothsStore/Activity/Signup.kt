package com.example.ClothsStore

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ClothsStore.userModel.MySignupmodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class Signup : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText

    private lateinit var etEmail: EditText

    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText

    private lateinit var btnSignup: Button
    private lateinit var tvAlreadyRegistered: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.mEmail)

        etPassword = findViewById(R.id.mPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)

        btnSignup = findViewById(R.id.SIGNUPbtn)
        tvAlreadyRegistered = findViewById(R.id.alredyloginBTN)

        btnSignup.setOnClickListener {
            val str_etFirstName = etFirstName.text.toString().trim()
            val str_etLastName = etLastName.text.toString().trim()
            val str_etEmail = etEmail.text.toString().trim()

            val str_etPassword = etPassword.text.toString().trim()
            val str_etConfirmPassword = etConfirmPassword.text.toString().trim()

            if (TextUtils.isEmpty(str_etFirstName)) {
                etFirstName.error = "Please enter your first name"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(str_etLastName)) {
                etLastName.error = "Please enter your last name"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(str_etEmail)) {
                etEmail.error = "Please enter your email address"
                return@setOnClickListener
            }
         //   !Patterns.EMAIL_ADDRESS.matcher(str_etEmail).matches()

            if (!isValidEmailAddress(str_etEmail)) {
                etEmail.error = "Please enter a valid email address"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(str_etPassword)) {
                etPassword.error = "Please enter your password"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(str_etConfirmPassword)) {
                etConfirmPassword.error = "Please enter your sam password"
                return@setOnClickListener
            }

            // Call API to register user
            val apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

            apiInterface.registerUser(str_etFirstName, str_etLastName, str_etEmail, str_etPassword,str_etConfirmPassword)

                .enqueue(object : Callback<MySignupmodel> {

                override fun onResponse(call: Call<MySignupmodel>, response: Response<MySignupmodel>)
                {
                    Log.e("Data 1:::", "Registration successfulllll:::" + response.body()?.status)
                    Log.e("Data 22:::", "Registration successfulllll:::" + response.body()?.message)
                    Log.e("Data 33:::", "Registration successfulllll:::" + response.body()?.data?.firstName)
                    Log.e("Data 44:::", "Registration successfulllll:::" + response.body()?.data?.lastName)
                    Log.e("Data 55:::", "Registration successfulllll:::" + response.body()?.data?.email)

                    if (response.body()?.status==200) {
                        val intent = Intent(this@Signup, Home_page::class.java)
                        startActivity(intent)
                        finish()
                        Toast.makeText(this@Signup,"Registration successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@Signup, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onFailure(call: Call<MySignupmodel>, t: Throwable) {
                    Log.e("Data 2:::", "Registration faileddddd:::" + t.message)

                    Toast.makeText(this@Signup, "Registration failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

        tvAlreadyRegistered.setOnClickListener {
            val intent = Intent(this@Signup, Login::class.java)
            startActivity(intent)

        }
    }
    ///Pattern email
    fun isValidEmailAddress(email: String?): Boolean {
        val ePattern =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(email!!)

        return m.matches()
    }
}
