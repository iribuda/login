package com.example.san.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.san.entities.Procedure;

import java.util.List;

@Dao
public interface ProcedureDao {

    @Insert
    void insert(Procedure procedure);

    @Delete
    void delete(Procedure procedure);

    @Update
    void update(Procedure procedure);

    @Query("SELECT * FROM procedure")
    LiveData<List<Procedure>> getAll();

    @Query("SELECT * FROM procedure WHERE isBought=1")
    LiveData<List<Procedure>> getBought();

}
