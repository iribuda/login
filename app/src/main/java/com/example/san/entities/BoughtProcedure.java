package com.example.san.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bought_procedures")
public class BoughtProcedure {

    @PrimaryKey
    private Integer id;

    private String name;

    private int price;

    private String date;

    private int photoResource;

    public BoughtProcedure(String name, int price, String date, int photoResource) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.photoResource = photoResource;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getPhotoResource() {
        return photoResource;
    }
}
