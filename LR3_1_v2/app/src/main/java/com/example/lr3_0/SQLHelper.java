package com.example.lr3_0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        if(oldVersion<newVersion){
            db.execSQL(FeedEntry.DEL_TABL);
            db.execSQL(FeedEntry.CREATE);
        }
    }
}
