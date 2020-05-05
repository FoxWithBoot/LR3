package com.example.lr3_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Row> rows = (ArrayList<Row>) getIntent().getSerializableExtra("rows");

        ListView list = findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(this, R.layout.row, rows.toArray(new Row[rows.size()]));
        list.setAdapter(adapter);
    }
}
