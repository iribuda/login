package com.example.san.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "procedure")
public class Procedure {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int price;

    private String startAt;

    private String endAt;

    private int isBought;

    private int photoResource;

    public Procedure(String name, int price, String startAt, String endAt, int photoResource) {
        this.name = name;
        this.price = price;
        this.startAt = startAt;
        this.endAt = endAt;
        this.photoResource = photoResource;
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

    public int getPrice() {
        return price;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public int getIsBought() {
        return isBought;
    }

    public void setIsBought(int isBought) {
        this.isBought = isBought;
    }
}
