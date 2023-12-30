package com.example.toy_project

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDB private constructor(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "User.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "user_data"
        const val COL1_ID = "_id"
        const val COL2_EMAIL = "email"
        const val COL3_PASSWORD = "password"

        //SingleTon Pattern(싱글톤 패턴)
        @Volatile
        private var instance: UserDB? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(UserDB::class.java) {
                instance ?: UserDB(context).also {
                    instance = it
                }
            }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL1_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL2_EMAIL TEXT, " +
                "$COL3_PASSWORD TEXT )"

        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion != newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }

    fun insertData(name: String, phone: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL2_EMAIL, name)
            put(COL3_PASSWORD, phone)
        }
        db.insert(TABLE_NAME, null, contentValues) // 값이 없으면 행을 삽입하지않음
    }

    fun updateData(id: String, name: String, phone: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL1_ID, id)
            put(COL2_EMAIL, name)
            put(COL3_PASSWORD, phone)
        }
        db.update(TABLE_NAME, contentValues, "$COL1_ID = ?", arrayOf(id))
    }

    fun getAllData(): String {
        var result = "No data in DB"

        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        try {
            if (cursor.count != 0) {
                val stringBuffer = StringBuffer()
                while (cursor.moveToNext()) {
                    stringBuffer.append("NAME :" + cursor.getString(1) + "\n")
                    stringBuffer.append("PHONE :" + cursor.getString(2) + "\n")
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
    }
}