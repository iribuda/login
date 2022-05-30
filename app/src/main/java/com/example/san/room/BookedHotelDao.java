package com.example.san.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.san.entities.BookedHotel;

import java.util.List;

@Dao
public interface BookedHotelDao {

    @Insert
    void insert(BookedHotel hotel);

    @Delete
    void delete(BookedHotel hotel);

    @Update
    void update(BookedHotel hotel);

    @Query("SELECT * FROM booked_hotel")
    LiveData<List<BookedHotel>> getAll();

}
