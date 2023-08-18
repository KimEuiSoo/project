package com.example.new_project.models.store

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StoreDB private constructor(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "Store.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "store_test"
        const val COL1_ID = "_id"
        const val COL2_USER = "user"
        const val COL3_ADDRESS = "address"
        const val COL4_LOCATION = "location"
        const val COL5_COMPANY = "company"
        const val COL6_BNO = "bno"
        const val COL7_SECOND_PASSWORD = "second_password"
        const val COL8_TYPE = "type"

        //SingleTon Pattern(싱글톤 패턴)
        @Volatile
        private var instance: StoreDB? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(StoreDB::class.java) {
                instance ?: StoreDB(context).also {
                    instance = it
                }
            }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL1_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL2_USER TEXT, " +
                "$COL3_ADDRESS TEXT," +
                "$COL4_LOCATION TEXT," +
                "$COL5_COMPANY TEXT," +
                "$COL6_BNO TEXT," +
                "$COL7_SECOND_PASSWORD TEXT," +
                "$COL8_TYPE TEXT )"

        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }

    fun insertData(store: StoreData) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL2_USER, store.user)
            put(COL3_ADDRESS, store.address)
            put(COL4_LOCATION, store.location)
            put(COL5_COMPANY, store.company)
            put(COL6_BNO, store.bno)
            put(COL7_SECOND_PASSWORD, store.second_password)
            put(COL8_TYPE, store.type)
        }
        db.insert(TABLE_NAME, null, contentValues) // 값이 없으면 행을 삽입하지않음
    }

    /*fun updateData(store: StoreData) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL1_ID, store.id)
            put(COL2_USER, store.user)
            put(COL3_ADDRESS, store.address)
            put(COL4_LOCATION, store.location)
            put(COL5_COMPANY, store.company)
            put(COL6_BNO, store.bno)
            put(COL7_SECOND_PASSWORD, store.second_password)
            put(COL8_TYPE, store.type)
        }
        db.update(TABLE_NAME, contentValues, "$COL1_ID = ?", arrayOf(store.id))
    }

    fun getAllData(): String {
        var result = "No data in DB"

        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        try {
            if (cursor.count != 0) {
                val stringBuffer = StringBuffer()
                while (cursor.moveToNext()) {
                    stringBuffer.append("USER :" + cursor.getString(1) + "\n")
                    stringBuffer.append("ADDRESS :" + cursor.getString(2) + "\n")
                    stringBuffer.append("COMPANY :" + cursor.getString(3) + "\n")
                    stringBuffer.append("BNO :" + cursor.getString(4) + "\n")
                }
                result = stringBuffer.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (cursor != null && !cursor.isClosed) {
                cursor.close()
            }
        }
        return result
    }*/
}

data class StoreData(
    var id: String,
    var user: String,
    var address: String,
    var location: String,
    var company: String,
    var bno: String,
    var second_password: String,
    var type: String
)