package com.example.database.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.database.StudentsModel

class database(context: Context?) : SQLiteOpenHelper(context,"MyData.db", null, 1) {

    var context = context


    override fun onCreate(db: SQLiteDatabase?) {

        var sql =
            "CREATE TABLE students(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,surname TEXT,address TEXT)"

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addData(name: String, surname: String, address: String) {

        var db = writableDatabase
        var value = ContentValues()
        value.put("name", name)
        value.put("surname", surname);
        value.put("address", address);
        db.insert("students", null, value)

    }

    fun showdata(): ArrayList<StudentsModel> {
        var stdList = ArrayList<StudentsModel>()
        var db = readableDatabase
        var sql = "SELECT * FROM students"
        var cursor: Cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()


        for (i in 0..cursor.count - 1) {

            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var surname = cursor.getString(2)
            var address = cursor.getString(3)

            var std = StudentsModel(id, name, surname, address)
            stdList.add(std)
            cursor.moveToNext()

        }
        return stdList
    }

}


