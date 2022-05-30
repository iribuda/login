package com.example.san.ui.bookedRoom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.san.entities.BookedHotel;
import com.example.san.entities.Hotel;
import com.example.san.repositories.BookedHotelRepository;
import com.example.san.repositories.HotelRepository;

import java.util.List;

public class BookedHotelViewModel extends AndroidViewModel {
    private BookedHotelRepository bookedHotelRepository;
    private LiveData<List<BookedHotel>> allBookedHotels;
//    private LiveData<List<Hotel>> reservedRooms;

    public BookedHotelViewModel(@NonNull Application application) {
        super(application);
        bookedHotelRepository = new BookedHotelRepository(application);
        allBookedHotels = bookedHotelRepository.getAllRooms();
//        reservedRooms = bookedHotelRepository.getReservedRooms();
    }

    public LiveData<List<BookedHotel>> getAllBookedHotels() {return allBookedHotels;}

    public void insert(BookedHotel bookedHotel){
        bookedHotelRepository.insert(bookedHotel);
    }

    public void update(BookedHotel bookedHotel){
        bookedHotelRepository.update(bookedHotel);
    }

    public void delete(BookedHotel bookedHotel){
        bookedHotelRepository.delete(bookedHotel);
    }
}