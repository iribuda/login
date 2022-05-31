package com.example.san.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.san.entities.BoughtProcedure;
import com.example.san.entities.Procedure;

import java.util.List;

@Dao
public interface BoughtProcedureDao {

    @Insert
    void insert(BoughtProcedure procedure);

    @Delete
    void delete(BoughtProcedure procedure);

    @Query("SELECT * FROM bought_procedures")
    LiveData<List<BoughtProcedure>> getAll();

    @Query("SELECT EXISTS (SELECT 1 FROM bought_procedures WHERE id=:id)")
    int isAddToBoughtProcedure(int id);

//    @Query("select COUNT (*) from bought_procedures")
//    int countBoughtProcedure();
}
