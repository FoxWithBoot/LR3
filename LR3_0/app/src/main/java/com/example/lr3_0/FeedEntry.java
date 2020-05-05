package com.example.lr3_0;

import android.provider.BaseColumns;

public class FeedEntry implements BaseColumns {
    public static final String DB_NAME = "BD";
    public static final String TABLE_NAME = "studTable";
    public static final String TITLE1 = "id";
    public static final String TITLE2 = "name";
    public static final String TITLE3 = "date";
    public static final int DB_VERS = 1;

    public static final String CREATE =
            "CREATE TABLE "
            +TABLE_NAME +"("
            +TITLE1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TITLE2+" TEXT,"
            +TITLE3+" TEXT"+");";

    public static final String CHANGE_NAME =
            "UPDATE "+TABLE_NAME
                    +" SET "+TITLE2+"='Иванов Иван Иванович'"
                    +"WHERE "+TITLE1+"=(SELECT MAX("+TITLE1+") FROM "+TABLE_NAME+");";



    public static final String DEL = "DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+TABLE_NAME+"'";
}
