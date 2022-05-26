package com.example.san.ui.procedures;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.san.entities.Procedure;
import com.example.san.repositories.ProcedureRepository;

import java.util.List;

public class ProcedureViewModel extends AndroidViewModel {

    private ProcedureRepository procedureRepository;
    private LiveData<List<Procedure>> allProcedure;

    public ProcedureViewModel(@NonNull Application application) {
        super(application);
        procedureRepository = new ProcedureRepository(application);
        allProcedure = procedureRepository.getAllProcedures();
    }

    public LiveData<List<Procedure>> getAllProcedure() {return allProcedure;}

    public void insert(Procedure procedure){
        procedureRepository.insert(procedure);
    }

    public void update(Procedure procedure){
        procedureRepository.update(procedure);
    }

    public void delete(Procedure procedure){
        procedureRepository.delete(procedure);
    }

}
