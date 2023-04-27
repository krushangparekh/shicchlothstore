package com.example.ClothsStore.DATABASE

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.Settings.Global.getString
import android.util.Log
import com.example.ClothsStore.productListModel
import java.lang.reflect.Array.getInt

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "cart.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "cart_items"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PRICE = "price"
        private const val KEY_SIZE = "size"
        private const val KEY_COLOR = "color"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE =
            ("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_PRICE + " TEXT, " + KEY_SIZE + " TEXT, " + KEY_COLOR + " LONG)")
        db!!.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun addToCart(name: String, price: String?, size: String, color: String, style: String?) {
        val db = this.writableDatabase
        val productListModel = ContentValues().apply {
            put(KEY_NAME, name)
            put(KEY_PRICE, price)
            put(KEY_SIZE, size)
            put(KEY_COLOR, color)
        }
        db.insertWithOnConflict(TABLE_NAME, null, productListModel, 0)
    }

    fun removeFromCart(productId: Int) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$KEY_ID = ?", arrayOf(productId.toString()))
    }

    fun getCartItems(): ArrayList<Product> {
        val productListModel : ArrayList<Product> = arrayListOf()
        val db = readableDatabase
//        val db = dbHelper.readableDatabase

        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)
//
//        Log.e("PRODUCT_cursor$$", db.rawQuery(query, null))
//        Log.e("PRODUCT_cursor$$", db.rawQuery(query, null))
//        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

//        with(cursor) {`
//            while (moveToNext()) {
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME))
            val price = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRICE))
            val size = cursor.getString(cursor.getColumnIndexOrThrow(KEY_SIZE))
            val color = cursor.getString(cursor.getColumnIndexOrThrow(KEY_COLOR))
            val product = Product(id, name, price, size, color)
            productListModel.add(product)
            Log.d("alldata", "id=$id, name=$name, price=$price, size$size, color$color")

        }
        cursor.close()
        return productListModel
    }

}
//        return productListModel




interface Plant {
}

class Product(
    id: Int,
    name: String?,
    price: String,
    size: String?,
    color: String,
) : Plant







/*

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "cart.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "cart_items"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PRICE = "price"
        private const val KEY_SIZE = "size"
        private const val KEY_COLOR = "color"
        private const val KEY_STYLE = "style"
    }

    override fun onCreate(db: SQLiteDatabase?) {

       */
/* val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, "
                    + KEY_PRICE + " TEXT, " + KEY_SIZE + " TEXT, " + KEY_COLOR + " LONG, )")*//*

        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY, " +  KEY_NAME + " TEXT, " + KEY_PRICE + " TEXT, " + KEY_SIZE + " TEXT, " + KEY_COLOR + " LONG)")
        db!!.execSQL(CREATE_CONTACTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun addToCart(name: String, price: String?, size: String, color: String, style: String?) {
        val db = this.writableDatabase
        val productListModel = ContentValues().apply {
            put(KEY_NAME, name)
            put(KEY_PRICE, price)
            put(KEY_SIZE, size)
            put(KEY_COLOR, color)
            put(KEY_STYLE, style)
        }
        db.insertWithOnConflict(TABLE_NAME, null, productListModel, 0)

//        db.close()
    }
    fun removeFromCart(productId: Int) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$KEY_ID = ?", arrayOf(productId.toString()))
//        db.close()
    }

    fun getCartItems(): List<productListModel> {
        val productListModel = mutableListOf<productListModel>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(KEY_ID))
                val name = getString(getColumnIndexOrThrow(KEY_NAME))
                val price = getString(getColumnIndexOrThrow(KEY_PRICE))
                val size = getString(getColumnIndexOrThrow(KEY_SIZE))
                val color = getString(getColumnIndexOrThrow(KEY_COLOR))
                val productListModel = Product(id, name, price, size, color)
                productListModel.run { productListModel }


            }
        }
        cursor.close()
//        db.close()
        return productListModel
    }

    fun addToCart(name: String, price: String, size: String, color: String) {

    }
}


interface Plant {
}

data class Product(
    val id: Int,
    val name: String?,
    val price: String,
    val size: String?,
    val color: String,
) : Plant

*/


