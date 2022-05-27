package com.example.san.ui.rooms;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.san.entities.Hotel;
import com.example.san.repositories.HotelRepository;

import java.util.List;

public class HotelViewModel extends AndroidViewModel {
    private HotelRepository hotelRepository;
    private LiveData<List<Hotel>> allRooms;

    public HotelViewModel(@NonNull Application application) {
        super(application);
        hotelRepository = new HotelRepository(application);
        allRooms = hotelRepository.getAllRooms();
    }

    public LiveData<List<Hotel>> getAllRoom() {return allRooms;}

    public void insert(Hotel hotel){
        hotelRepository.insert(hotel);
    }

    public void update(Hotel hotel){
        hotelRepository.update(hotel);
    }

    public void delete(Hotel hotel){
        hotelRepository.delete(hotel);
    }
}
