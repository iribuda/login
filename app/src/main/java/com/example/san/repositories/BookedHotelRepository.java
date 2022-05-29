package com.example.san.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.san.entities.BookedHotel;
import com.example.san.room.AppDatabase;
import com.example.san.room.BookedHotelDao;

import java.util.List;

public class BookedHotelRepository {
    private BookedHotelDao bookedHotelDao;
    private LiveData<List<BookedHotel>> allBookedHotels;

    public BookedHotelRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        bookedHotelDao = database.bookedHotelDao();
        allBookedHotels = bookedHotelDao.getAll();
    }

    public void insert(BookedHotel bookedHotel){
        new BookedHotelRepository.InsertRoomAsyncTask(bookedHotelDao).execute(bookedHotel);
    }

    public void update(BookedHotel bookedHotel){
        new BookedHotelRepository.UpdateRoomAsyncTask(bookedHotelDao).execute(bookedHotel);
    }

    public void delete(BookedHotel bookedHotel){
        new BookedHotelRepository.DeleteRoomAsyncTask(bookedHotelDao).execute(bookedHotel);
    }

    public LiveData<List<BookedHotel>> getAllRooms() {
        return allBookedHotels;
    }

    private static class InsertRoomAsyncTask extends AsyncTask<BookedHotel, Void, Void> {
        private BookedHotelDao bookedHotelDao;

        private InsertRoomAsyncTask(BookedHotelDao bookedHotelDao) {
            this.bookedHotelDao = bookedHotelDao;
        }

        @Override
        protected Void doInBackground(BookedHotel... bookedHotels) {
            bookedHotelDao.insert(bookedHotels[0]);
            return null;
        }
    }

    private static class UpdateRoomAsyncTask extends AsyncTask<BookedHotel, Void, Void> {
        private BookedHotelDao bookedHotelDao;

        private UpdateRoomAsyncTask(BookedHotelDao bookedHotelDao) {
            this.bookedHotelDao = bookedHotelDao;
        }

        @Override
        protected Void doInBackground(BookedHotel... bookedHotels) {
            bookedHotelDao.update(bookedHotels[0]);
            return null;
        }
    }

    private static class DeleteRoomAsyncTask extends AsyncTask<BookedHotel, Void, Void> {
        private BookedHotelDao bookedHotelDao;

        private DeleteRoomAsyncTask(BookedHotelDao bookedHotelDao) {
            this.bookedHotelDao = bookedHotelDao;
        }

        @Override
        protected Void doInBackground(BookedHotel... bookedHotels) {
            bookedHotelDao.delete(bookedHotels[0]);
            return null;
        }
    }
}
