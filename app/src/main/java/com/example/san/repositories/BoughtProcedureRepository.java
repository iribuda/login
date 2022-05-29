package com.example.san.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.san.entities.BoughtProcedure;
import com.example.san.entities.Procedure;
import com.example.san.room.AppDatabase;
import com.example.san.room.BoughtProcedureDao;
import com.example.san.room.ProcedureDao;

import java.util.List;

public class BoughtProcedureRepository {

    private BoughtProcedureDao dao;
    private LiveData<List<BoughtProcedure>> allBoughtProcedures;

    public BoughtProcedureRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        dao = database.boughtProcedureDao();
        allBoughtProcedures = dao.getAll();
    }

    public void insert(BoughtProcedure procedure){
        new BoughtProcedureRepository.InsertBoughtProcedureAsyncTask(dao).execute(procedure);
    }

    public void delete(BoughtProcedure procedure){
        new BoughtProcedureRepository.DeleteBoughtProcedureAsyncTask(dao).execute(procedure);
    }

    public LiveData<List<BoughtProcedure>> getAllBoughtProcedures() {
        return allBoughtProcedures;
    }

    public int isAddToBoughtProcedure(BoughtProcedure boughtProcedure){
        return dao.isAddToBoughtProcedure(boughtProcedure.getId());
    }

    private static class InsertBoughtProcedureAsyncTask extends AsyncTask<BoughtProcedure, Void, Void> {
        private BoughtProcedureDao dao;

        private InsertBoughtProcedureAsyncTask(BoughtProcedureDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(BoughtProcedure... procedures) {
            dao.insert(procedures[0]);
            return null;
        }
    }

    private static class DeleteBoughtProcedureAsyncTask extends AsyncTask<BoughtProcedure, Void, Void> {
        private BoughtProcedureDao dao;

        private DeleteBoughtProcedureAsyncTask(BoughtProcedureDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(BoughtProcedure... procedures) {
            dao.delete(procedures[0]);
            return null;
        }
    }
}

