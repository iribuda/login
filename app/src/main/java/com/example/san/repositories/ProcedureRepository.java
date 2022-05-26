package com.example.san.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.san.entities.Procedure;
import com.example.san.room.AppDatabase;
import com.example.san.room.ProcedureDao;

import java.util.List;

public class ProcedureRepository {

    private ProcedureDao procedureDao;
    private LiveData<List<Procedure>> allProcedures;

    public ProcedureRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        procedureDao = database.procedureDao();
        allProcedures = procedureDao.getAll();
    }

    public void insert(Procedure procedure){
        new InsertProcedureAsyncTask(procedureDao).execute(procedure);
    }

    public void update(Procedure procedure){
        new UpdateProcedureAsyncTask(procedureDao).execute(procedure);
    }

    public void delete(Procedure procedure){
        new DeleteProcedureAsyncTask(procedureDao).execute(procedure);
    }

    public LiveData<List<Procedure>> getAllProcedures() {
        return allProcedures;
    }

    private static class InsertProcedureAsyncTask extends AsyncTask<Procedure, Void, Void> {
        private ProcedureDao procedureDao;

        private InsertProcedureAsyncTask(ProcedureDao procedureDao) {
            this.procedureDao = procedureDao;
        }

        @Override
        protected Void doInBackground(Procedure... procedures) {
            procedureDao.insert(procedures[0]);
            return null;
        }
    }

    private static class UpdateProcedureAsyncTask extends AsyncTask<Procedure, Void, Void> {
        private ProcedureDao procedureDao;

        private UpdateProcedureAsyncTask(ProcedureDao procedureDao) {
            this.procedureDao = procedureDao;
        }

        @Override
        protected Void doInBackground(Procedure... procedures) {
            procedureDao.update(procedures[0]);
            return null;
        }
    }

    private static class DeleteProcedureAsyncTask extends AsyncTask<Procedure, Void, Void> {
        private ProcedureDao procedureDao;

        private DeleteProcedureAsyncTask(ProcedureDao procedureDao) {
            this.procedureDao = procedureDao;
        }

        @Override
        protected Void doInBackground(Procedure... procedures) {
            procedureDao.delete(procedures[0]);
            return null;
        }
    }
}
