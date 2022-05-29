package com.example.san.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.san.entities.Hotel;
import com.example.san.room.AppDatabase;
import com.example.san.room.HotelDao;

import java.util.List;

public class HotelRepository {
    private HotelDao hotelDao;
    private LiveData<List<Hotel>> allRooms;
//    private LiveData<List<Hotel>> reservedRooms;

    public HotelRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        hotelDao = database.roomDao();
        allRooms = hotelDao.getAll();
//        reservedRooms = hotelDao.getReserved();
    }

    public void insert(Hotel hotel){
        new HotelRepository.InsertRoomAsyncTask(hotelDao).execute(hotel);
    }

    public void update(Hotel hotel){
        new HotelRepository.UpdateRoomAsyncTask(hotelDao).execute(hotel);
    }

    public void delete(Hotel hotel){
        new HotelRepository.DeleteRoomAsyncTask(hotelDao).execute(hotel);
    }

    public LiveData<List<Hotel>> getAllRooms() {
        return allRooms;
    }

//    public LiveData<List<Hotel>> getReservedRooms() {
//        return reservedRooms;
//    }

    private static class InsertRoomAsyncTask extends AsyncTask<Hotel, Void, Void> {
        private HotelDao hotelDao;

        private InsertRoomAsyncTask(HotelDao hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.insert(hotels[0]);
            return null;
        }
    }

    private static class UpdateRoomAsyncTask extends AsyncTask<Hotel, Void, Void> {
        private HotelDao hotelDao;

        private UpdateRoomAsyncTask(HotelDao hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.update(hotels[0]);
            return null;
        }
    }

    private static class DeleteRoomAsyncTask extends AsyncTask<Hotel, Void, Void> {
        private HotelDao hotelDao;

        private DeleteRoomAsyncTask(HotelDao hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.delete(hotels[0]);
            return null;
        }
    }
}