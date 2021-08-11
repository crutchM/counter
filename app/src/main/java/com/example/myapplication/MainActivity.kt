package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val _db = DB(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTotal()
        updateTotal()
        resetCounter()
    }

    private fun updateTotal() {
        button.setOnClickListener{
            updateDb()
            showTotal()
        }
    }

    private fun resetCounter(){
        button2.setOnClickListener{
            resetDB()
            showTotal()
        }
    }

    fun updateDb( ) {
        _db.writableDatabase.execSQL("INSERT INTO COUNTER(id, number) VALUES (null, 1)")
    }

    fun showTotal(){
        val cursor = _db.readableDatabase.rawQuery("SELECT number FROM COUNTER", null)
        var result = 0
        cursor.moveToFirst()
        while (cursor.moveToNext()) {
           result += cursor.getInt(cursor.getColumnIndex("number"))
        }
        totalView.text = result.toString()
    }

    fun resetDB(){
        _db.writableDatabase.execSQL("DELETE FROM COUNTER WHERE id > 1")
    }
}
