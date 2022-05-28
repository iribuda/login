package com.example.san.entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotel")
public class Hotel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int photoResource;

    private int isReserved;

    private String date;

    public Hotel(int id, String name, int photoResource) {
        this.id = id;
        this.name = name;
        this.photoResource = photoResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        this.photoResource = photoResource;
    }

    public int getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(int isReserved) {
        this.isReserved = isReserved;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}