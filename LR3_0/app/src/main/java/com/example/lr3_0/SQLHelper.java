package com.example.lr3_0;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context context, int ver) { //конструктор
        super(context, FeedEntry.DB_NAME, null, ver);

    }

    @Override
    public void onCreate(SQLiteDatabase db) { //для создания БД
        db.execSQL(FeedEntry.CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //для обновления

    }
}
