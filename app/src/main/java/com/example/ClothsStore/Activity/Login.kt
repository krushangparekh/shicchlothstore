package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ClothsStore.userModel.Datalogin
import com.example.ClothsStore.userModel.loginBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class Login : AppCompatActivity() {
    private lateinit var buttonforgetpassword: Button
    private lateinit var BTNsignin: Button
    private lateinit var text_new_user: Button
    private lateinit var mEmailedittext: EditText
    private lateinit var passwordedittext: EditText

    private lateinit var progressBar: ProgressBar

    @Suppress("DEPRECATION")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonforgetpassword = findViewById(R.id.buttonforgetpassword)     //forgetbutton
        BTNsignin = findViewById(R.id.BTNsignin)                             // signin button
        text_new_user = findViewById(R.id.text_new_user)                     //   new user button

        mEmailedittext = findViewById(R.id.mEmailedittext)                 //   Email
        passwordedittext = findViewById(R.id.passwordedittext)             //  password
        progressBar = findViewById(R.id.progressBar)

        //intent   forget button
        buttonforgetpassword.setOnClickListener {
            val intent = Intent(this@Login, ForgetPassword::class.java)
            startActivity(intent)
            finish()
        }
        //intent   new user button
        BTNsignin.setOnClickListener {

            ////log how data pass on click
            Log.e("Data 1:::", "mEmailedittext:::" + mEmailedittext.text.toString())
            Log.e("Data 2:::", "mEmailedittext:::" + passwordedittext.text.toString().trim().length)

            if (mEmailedittext.text.toString().trim().length === 0) {
                mEmailedittext.error = "Email is not entered"
                mEmailedittext.requestFocus()

            } else if (mEmailedittext.text.toString().trim().length === 0) {
                mEmailedittext.error = "Email is not entered"
                mEmailedittext.requestFocus()

            } else if (passwordedittext.text.toString().trim().length === 0) {
                passwordedittext.error = "Password is not entered"
                passwordedittext.requestFocus()

            } else if (passwordedittext.text.toString().trim().length === 0) {
                passwordedittext.error = "Password is not entered"
                passwordedittext.requestFocus()
            } else {

                progressBar.visibility = View.VISIBLE

                val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
                loginBody(mEmailedittext.toString(), passwordedittext.toString())

                retIn.loginUser(
                    mEmailedittext.text.toString(),
                    passwordedittext.text.toString(),
                ).enqueue(object : Callback<Datalogin> {
                    override fun onFailure(call: Call<Datalogin>, t: Throwable) {
                        Log.e("Data 2:::", "t.message:::" + t.message)
                        Toast.makeText(this@Login, t.message, Toast.LENGTH_SHORT).show() }
                    override fun onResponse(call: Call<Datalogin>, response: Response<Datalogin>) {
                        Log.e("Data 2:::", "response:::" + response.body())
                        progressBar.visibility = View.GONE
                        if (response.code() == 200) {
                            Toast.makeText(applicationContext, "Login successful!", Toast.LENGTH_SHORT).show()
//                                val intent = Intent(this@Login, Home_page::class.java)
//                                startActivity(intent)
//                                finish()
                            ///Intent///
                            val intent = Intent(this@Login, Home_page::class.java)
                            startActivity(intent)
                            finish()

                            ///data save in localstore/////
                            val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            editor.putString("userName", mEmailedittext.text.toString())
                            editor.putBoolean("islogin",true)
                            editor.apply()
//                            preferencemanager.getdefaultsharedpreferences(this@Login).edit().putstring("username",mEmailedittext.text.toString()).apply();
                        } else {
                            Toast.makeText(applicationContext, "Login failed!", Toast.LENGTH_SHORT).show()
                        }




                    }
                })
            }
        }

        text_new_user.setOnClickListener {
            val intent = Intent(this@Login, Signup::class.java)
            startActivity(intent)
            finish()
        }
    }
}

/*  startActivity(Intent(this@Login, Home_page::class.java))
  finish()*/
