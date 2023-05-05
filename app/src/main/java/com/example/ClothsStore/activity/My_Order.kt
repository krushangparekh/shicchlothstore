package com.example.ClothsStore.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.ClothsStore.R

class My_Order : AppCompatActivity() {
   /* lateinit var webview2: WebView
    lateinit var PBBarview: ProgressBar*/

    @SuppressLint("MissingInflatedId", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_order)
       /* PBBarview = findViewById(R.id.PBBarview)
        webview2 = findViewById(R.id.webview2)
        webview2.settings.javaScriptEnabled = true*/
//        webview2.loadUrl("https://admin.shopify.com/store/shiv-cloths-store/orders")
        /*webview2.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                PBBarview.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            *//*override fun onPageFinished(view: WebView?, url: String?) {
                PBBarview.visibility = View.GONE
                super.onPageFinished(view, url)
            }*//*
        }*/
    }

   /* @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (webview2.canGoBack()) {
            webview2.goBack()
        } else {
            super.onBackPressed()
        }
    }*/
}



