package com.example.lr3_0;

import android.provider.BaseColumns;

public class FeedEntry implements BaseColumns {
    public static final String DB_NAME = "BD";
    public static final String TABLE_NAME = "studTable";
    public static final String TITLE_ID = "id";
    public static final String TITLE_NAME = "name";
    public static final String TITLE_NAME2 = "name2";
    public static final String TITLE_NAME3 = "name3";
    public static final String TITLE_DATE = "date";
    public static final int DB_VERS = 2;

    public static final String CREATE =
            "CREATE TABLE "
            +TABLE_NAME +"("
            +TITLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            +TITLE_NAME+" TEXT,"
            +TITLE_NAME2+" TEXT,"
            +TITLE_NAME3+" TEXT,"
            +TITLE_DATE+" TEXT"+");";

    public static final String CHANGE_NAME =
            "UPDATE "+TABLE_NAME
                    +" SET "
                    +TITLE_NAME+"='Иванов ', "
                    +TITLE_NAME2+"='Иван ', "
                    +TITLE_NAME3+"='Иванович ' "
                    +"WHERE "+TITLE_ID+"=(SELECT MAX("+TITLE_ID+") FROM "+TABLE_NAME+");";



    public static final String DEL = "DELETE FROM SQLITE_SEQUENCE WHERE NAME = '"+TABLE_NAME+"'";

    public static final String DEL_TABL = "DROP TABLE "+TABLE_NAME;
}
