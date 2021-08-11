package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB(private val context: Context?) :
    SQLiteOpenHelper(context, "COUNTER", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
       db.execSQL("CREATE TABLE COUNTER(id INTEGER PRIMARY KEY AUTOINCREMENT, number INTEGER NOT NULL)")
        db.execSQL("INSERT INTO COUNTER(id, number) VALUES (NULL, 0)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}
