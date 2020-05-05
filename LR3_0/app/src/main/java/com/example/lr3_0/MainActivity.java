package com.example.lr3_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Button showB;
    private Button addB;
    private Button changeB;

    private SQLiteDatabase db;
    private MyTask t;
    private SQLHelper help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showB = findViewById(R.id.button1);
        addB = findViewById(R.id.button2);
        changeB = findViewById(R.id.button3);

        help = new SQLHelper(this, FeedEntry.DB_VERS); //сознание и управление версиями

        t = new MyTask();
        t.execute(0);
    }

    public void onClick(View v) {
        MyTask t = new MyTask();
        t.execute(v.getId());
    }

    class MyTask extends AsyncTask<Integer, Void, Void> {
        ArrayList<Row> rows = null;

        @Override
        protected Void doInBackground(Integer... id) {
            ContentValues cv;
            db = help.getWritableDatabase(); // подключение к БД

            switch (id[0]){
                case 0:
                    db.delete(FeedEntry.TABLE_NAME, null, null); // удаление всех записей
                    db.execSQL(FeedEntry.DEL); //обнуление id
                    String [] stud = new String[]{
                            "Аляутдинов Равиль Раисович",
                            "Маркин Виктор Владимирович",
                            "Черкасова Анастасия Александровна",
                            "Лаухина Александра Сергеевна",
                            "Мазанова Екатерина Андреевна"};

                    cv = new ContentValues(); // объект данных

                    for(int q=0; q<stud.length; q++) {
                        cv.put(FeedEntry.TITLE2, stud[q]);
                        cv.put(FeedEntry.TITLE3, new Date().toString());
                        long l = db.insert(FeedEntry.TABLE_NAME, null, cv); //добавление записи
                    }
                    break;

                case R.id.button1:
                    rows = getRow();
                    break;

                case R.id.button2:
                    cv = new ContentValues(); // объект данных
                    cv.put(FeedEntry.TITLE2, "Горностаев Андрей Константинович");
                    cv.put(FeedEntry.TITLE3, new Date().toString());
                    long l = db.insert(FeedEntry.TABLE_NAME, null, cv); //добавление записи
                    break;

                case R.id.button3:
                    db.execSQL(FeedEntry.CHANGE_NAME);
                    break;
            }

            help.close(); // закрыть подключение
            return null;
        }

        @Override
        protected void onPostExecute(Void voids) {
            if(rows!=null){
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                //intent.putExtra("rows", rows);
                intent.putExtra("rows", (Serializable) rows);
                startActivity(intent);
            }
        }
    }

    private ArrayList<Row> getRow(){
        ArrayList<Row> rows = new ArrayList<>();
        // SELECT * FROM studTable
        Cursor c = db.query(FeedEntry.TABLE_NAME, null, null, null, null, null, null);
        while(c.moveToNext()){
            rows.add(new Row(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("date"))));
        }
        c.close();
        return rows;
    }

    @Override
    protected void onDestroy(){
        help.close();
        super.onDestroy();
    }
}
