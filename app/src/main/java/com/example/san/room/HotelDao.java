package com.example.san.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.san.entities.Hotel;
import com.example.san.entities.Procedure;

import java.util.List;

@Dao
public interface HotelDao {
    @Insert
    void insert(Hotel hotel);

    @Delete
    void delete(Hotel hotel);

    @Update
    void update(Hotel hotel);

    @Query("SELECT * FROM hotel")
    LiveData<List<Hotel>> getAll();

    @Query("SELECT * FROM hotel WHERE isReserved=1")
    LiveData<List<Hotel>> getReserved();
}