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

class Buy_now_Activity : AppCompatActivity() {
     lateinit var webview: WebView
     lateinit var PBprogressBarview: ProgressBar


    @SuppressLint("MissingInflatedId", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_now)

        PBprogressBarview = findViewById(R.id.PBprogressBarview)
        webview = findViewById(R.id.webview)
        webview.settings.javaScriptEnabled = true
//        webview.loadUrl("https://shiv-cloths-store.myshopify.com/checkouts/c/5a27a814becbea4e27440c9eac1f6081/information")
        webview.loadUrl("https://shiv-cloths-store.myshopify.com/")
        webview.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                PBprogressBarview.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                PBprogressBarview.visibility = View.GONE
                super.onPageFinished(view, url)
            }
        }
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }



}