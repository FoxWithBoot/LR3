package com.example.lr3_0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter<Row> {
    private LayoutInflater inflater;
    private int layout;
    private Row[] rows;

    public ListAdapter(Context context, int resource, Row[] rows){
        super(context, resource, rows);
        layout=resource;
        inflater=LayoutInflater.from(context);
        this.rows=rows;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layout, parent, false);
        TextView t1 = view.findViewById(R.id.textView1);
        TextView t2 = view.findViewById(R.id.textView2);
        TextView t3 = view.findViewById(R.id.textView3);
        t1.setText(String.valueOf(rows[position].getId()));
        t2.setText(rows[position].getName());
        t3.setText(rows[position].getDate());
        return view;
    }

}
