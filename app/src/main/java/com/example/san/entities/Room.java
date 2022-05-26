package com.example.san.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "room")
public class Room {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private int price;

    private int photoResource;
}
