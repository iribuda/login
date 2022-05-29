package com.example.san.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booked_hotel")
public class BookedHotel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int photoResource;

    private String date;

    public BookedHotel(String name, int photoResource, String date) {
        this.name = name;
        this.photoResource = photoResource;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public String getDate() {
        return date;
    }
}
