package com.example.ClothsStore

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//////////////////////save data ////////////
class task : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etName2: EditText
    private lateinit var etId: EditText
    private lateinit var etId2: EditText
    private lateinit var btnSave: Button
    private lateinit var tvName: TextView
    private lateinit var tvName2: TextView
    private lateinit var tvId: TextView
    private lateinit var tvId2: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        etName = findViewById(R.id.etName)
        etName2 = findViewById(R.id.etName2)
        etId = findViewById(R.id.etId)
        etId2 = findViewById(R.id.etId2)
        btnSave = findViewById(R.id.btnSave)
        tvName = findViewById(R.id.tvName)
        tvName2 = findViewById(R.id.tvName2)
        tvId = findViewById(R.id.tvId)
        tvId2 = findViewById(R.id.tvId2)


        btnSave.setOnClickListener {
            Log.e("Data 1:::", "etName:::" + etName.text.toString())
            Log.e("Data 2:::", "etId:::" + etId.text.toString())
            Log.e("Data ----:::", "btnSave:::" + btnSave.text.toString())
            Log.e("Data 00:::", "tvName:::" + tvName.text.toString())
            Log.e("Data 0000:::", "tvId:::" + tvId.text.toString())

            val sharedPreference = getSharedPreferences("task", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("name", etName.text.toString())
            editor.putString("id", etId.text.toString())
//            editor.putInt("phonumber", 14)
//            editor.putBoolean("dddd", true)
            editor.apply()

            val sharedPreferences = getSharedPreferences("task", Context.MODE_PRIVATE)
            val name = sharedPreferences.getString("name", " ")
            val id = sharedPreferences.getString("id"," " )
//            val nnn = sharedPreferences.getInt("phonumber",0)
//            val dddd = sharedPreferences.getBoolean("dddd",false)

            tvName.text = etName.text.toString()
            tvId.text = etId.text.toString()

            tvName.text = name
            tvId.text = id
        }
    }
}

/*

class productsdata {
    var id: Int? = null
    var title: String? = null
    var bodyHtml: String? = null
    var vendor: String? = null
    var productType: String? = null
    var createdAt: String? = null
    var handle: String? = null
    var updatedAt: String? = null
    var publishedAt: String? = null
    var templateSuffix: String? = null
    var status: String? = null
    var publishedScope: String? = null
    var tags: String? = null
    var adminGraphqlApiId: String? = null
    var variants: List<Variant> = ArrayList()
    var options: List<Option> = ArrayList()
    var images: List<Image> = ArrayList()
    var image: Image_? = null
}

class Image {
    var id: Int? = null
    var productId: Int? = null
    var position: Int? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var alt: Any? = null
    var width: Int? = null
    var height: Int? = null
    var src: String? = null
    var variantIds: List<Any> = ArrayList()
    var adminGraphqlApiId: String? = null
}

class Image_ {
    var id: Int? = null
    var productId: Int? = null
    var position: Int? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var alt: Any? = null
    var width: Int? = null
    var height: Int? = null
    var src: String? = null
    var variantIds: List<Any> = ArrayList()
    var adminGraphqlApiId: String? = null
}

class Option {
    var id: Int? = null
    var productId: Int? = null
    var name: String? = null
    var position: Int? = null
    var values: List<String> = ArrayList()
}

class com.example.ClothsStore.userModel.Root {
    var status: Int? = null
    var message: String? = null
    var data: List<com.example.ClothsStore.userModel.Datum> = ArrayList<com.example.ClothsStore.userModel.Datum>()
}

class Variant {
    var id: Int? = null
    var productId: Int? = null
    var title: String? = null
    var price: String? = null
    var sku: String? = null
    var position: Int? = null
    var inventoryPolicy: String? = null
    var compareAtPrice: Any? = null
    var fulfillmentService: String? = null
    var inventoryManagement: String? = null
    var option1: String? = null
    var option2: String? = null
    var option3: String? = null
    var createdAt: String? = null
    var updatedAt: String? = null
    var taxable: Boolean? = null
    var barcode: String? = null
    var grams: Int? = null
    var imageId: Any? = null
    var weight: Int? = null
    var weightUnit: String? = null
    var inventoryItemId: Int? = null
    var inventoryQuantity: Int? = null
    var oldInventoryQuantity: Int? = null
    var requiresShipping: Boolean? = null
    var adminGraphqlApiId: String? = null
}

*/


