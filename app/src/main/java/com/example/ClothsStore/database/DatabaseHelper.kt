package com.example.ClothsStore.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.bumptech.glide.load.model.Model

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
        val productListModel: ArrayList<Product> = arrayListOf()
        val db = readableDatabase


        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

//        Log.e("PRODUCT_cursor$$", db.rawQuery(query, null))
//        Log.e("PRODUCT_cursor$$", db.rawQuery(query, null))
//        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME))
            val price = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRICE))
            val size = cursor.getString(cursor.getColumnIndexOrThrow(KEY_SIZE))
            val color = cursor.getString(cursor.getColumnIndexOrThrow(KEY_COLOR))
            val product = Product(id, name, price, size)
            productListModel.add(product)
            Log.d("alldata", "id=$id, name=$name, price=$price, size$size, color$color")
        }
        cursor.close()
        return productListModel
    }

    fun readCourses(): ArrayList<Product>? {
        // on below line we are creating a
        // database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // on below line we are creating a new array list.
        val courseModalArrayList: ArrayList<Product> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(
                    Product(
                        cursorCourses.getInt(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)
                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close()
        return courseModalArrayList
    }

}

private operator fun SQLiteDatabase.invoke(
    productListModel: ArrayList<Product>,
    java: Class<Model>
) {
}

interface Plant {
}

class Product(
    id: Int,
    name: String?,
    price: String,
    size: String?,
) : Plant
