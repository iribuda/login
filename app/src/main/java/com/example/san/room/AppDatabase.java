package com.example.san.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.san.R;
import com.example.san.entities.BookedHotel;
import com.example.san.entities.Hotel;
import com.example.san.entities.Procedure;

@Database(entities = {Procedure.class, BoughtProcedure.class, Hotel.class, BookedHotel.class}, version = 11, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    public abstract BoughtProcedureDao boughtProcedureDao();
    public abstract ProcedureDao procedureDao();
    public abstract HotelDao roomDao();
    public abstract BookedHotelDao bookedHotelDao();

    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "san_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProcedureDao procedureDao;
        private HotelDao hotelDao;
        private BookedHotelDao bookedHotelDao;

        private PopulateDbAsyncTask(AppDatabase database){
            procedureDao = database.procedureDao();
            hotelDao = database.roomDao();
            bookedHotelDao = database.bookedHotelDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

//            Time startTime1 = new Time(8);
//            Time endTime1 = new Time(9);
//
//            Time startTime2 = new Time(10);
//            Time endTime2 = new Time(10,30, 0);
//
//            Time startTime3 = new Time(10, 30, 0);
//            Time endTime3 = new Time(12);
//
//            Time startTime4 = new Time(13);
//            Time endTime4 = new Time(14);
//
//            Time startTime5 = new Time(14);
//            Time endTime5 = new Time(15);
//
//            Time startTime6 = new Time(15);
//            Time endTime6 = new Time(16);
//
//            Time startTime7 = new Time(18);
//            Time endTime7 = new Time(19);
//
//            Time startTime8 = new Time(19);
//            Time endTime8 = new Time(21);

            hotelDao.insert(new Hotel(1, "Стандарт одноместный", R.drawable.b1));
            hotelDao.insert(new Hotel(2, "Стандарт двухместный", R.drawable.b2));
            hotelDao.insert(new Hotel(3, "Стандарт трехместный", R.drawable.b3));
            hotelDao.insert(new Hotel(4, "Люкс двухместный", R.drawable.b4));

            procedureDao.insert(new Procedure("Акупунктура", 150, "14:00", "15:00", R.drawable.a1));
            procedureDao.insert(new Procedure("Траволечение", 120, "14:00", "15:00", R.drawable.a2));
            procedureDao.insert(new Procedure("Фототерапия", 110, "14:00", "15:00", R.drawable.a3));
            procedureDao.insert(new Procedure("Физиотерапия", 120, "14:00", "15:00", R.drawable.a4));
            procedureDao.insert(new Procedure("Массаж", 140, "14:00", "15:00", R.drawable.a5));
            procedureDao.insert(new Procedure("Грязевые ванны", 130, "14:00", "15:00", R.drawable.a6));
            procedureDao.insert(new Procedure("Гидромассаж", 150, "14:00", "15:00", R.drawable.a7));
            procedureDao.insert(new Procedure("Ванны", 110, "14:00", "15:00", R.drawable.a8));

            return null;
        }
    }
}
