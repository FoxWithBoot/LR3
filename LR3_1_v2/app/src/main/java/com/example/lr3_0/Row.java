package com.example.lr3_0;

import java.io.Serializable;

public class Row implements Serializable {
    private int id;
    private String name;
    private String date;

    public Row(int id, String name, String name2, String name3, String date){
        this.id=id;
        this.name=name+name2+name3;
        this.date=date;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDate() {
        return date;
    }

}
