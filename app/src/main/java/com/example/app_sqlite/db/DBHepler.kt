package com.example.app_sqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHepler (context: Context, factory: SQLiteDatabase.CursorFactory?):
SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase){
        val query = ("CREATE TABLE "+TABLE_NAME+" ("
                +ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + "TEXT, "+
                TEL_COL+ "TEXT "+
                OBS_COL+"TEXT"+")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1:Int, p2: Int){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME)
        onCreate(db)
    }

    fun addPessoa(name:String, observacao:String, tel :String,){
        val values = ContentValues()
        values.put(NAME_COL, name)
        values.put(OBS_COL, observacao)
        values.put(TEL_COL, tel)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    companion object{
        private val DATABASE_NAME = "appSQLite"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "CadastroPessoa"
        val ID_COL = "id"
        val NAME_COL = "name"
        val OBS_COL = "observacao"
        val TEL_COL = "tel"
    }
}