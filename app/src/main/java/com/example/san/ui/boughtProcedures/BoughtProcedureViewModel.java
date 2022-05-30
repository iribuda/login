package com.example.san.ui.boughtProcedures;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.san.entities.BoughtProcedure;
import com.example.san.repositories.BoughtProcedureRepository;

import java.util.List;

public class BoughtProcedureViewModel extends AndroidViewModel {

    private BoughtProcedureRepository repository;
    private LiveData<List<BoughtProcedure>> allBoughtProcedures;

    public BoughtProcedureViewModel(@NonNull Application application) {
        super(application);
        this.repository = new BoughtProcedureRepository(application);
        this.allBoughtProcedures = repository.getAllBoughtProcedures();
    }

    public LiveData<List<BoughtProcedure>> getAllBoughtProcedures(){
        return allBoughtProcedures;
    }

    public void insert(BoughtProcedure boughtProcedure){
        repository.insert(boughtProcedure);
    }

    public void delete(BoughtProcedure boughtProcedure){
        repository.delete(boughtProcedure);
    }

    public int isAddToBoughtProcedure(BoughtProcedure boughtProcedure){
        return repository.isAddToBoughtProcedure(boughtProcedure);
    }
}
