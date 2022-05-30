package com.example.san.ui.bookedRoom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.BookedRoomItemBinding;
import com.example.san.databinding.RoomItemBinding;
import com.example.san.entities.BookedHotel;
import com.example.san.entities.Hotel;
import com.example.san.ui.hotelRooms.HotelViewModel;
import com.example.san.ui.hotelRooms.HotelsFragment;

import java.util.ArrayList;
import java.util.List;

public class BookedHotelAdapter extends RecyclerView.Adapter<BookedHotelAdapter.RoomHolder>{
    private List<BookedHotel> reservedHotels = new ArrayList<>();
    private BookedHotelViewModel bookedHotelViewModel;
    private BookedRoomFragment bookedRoomFragment;

    @NonNull
    @Override
    public BookedHotelAdapter.RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BookedRoomItemBinding binding = BookedRoomItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BookedHotelAdapter.RoomHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookedHotelAdapter.RoomHolder holder, int position) {
        BookedHotel hotel = reservedHotels.get(position);

        holder.binding.hotelName.setText(hotel.getName());
        holder.binding.hotelImage.setImageResource(hotel.getPhotoResource());
        holder.binding.date.setText(hotel.getDate());
    }

    @Override
    public int getItemCount() {
        return reservedHotels.size();
    }

    public static class RoomHolder extends RecyclerView.ViewHolder {
        BookedRoomItemBinding binding;

        public RoomHolder(@NonNull BookedRoomItemBinding roomItemBinding) {
            super(roomItemBinding.getRoot());
            this.binding = roomItemBinding;
        }
    }

    public void setRooms(List<BookedHotel> hotels){
        this.reservedHotels = hotels;
        notifyDataSetChanged();
    }

    public void setRoomViewModel(BookedHotelViewModel hotelViewModel){
        this.bookedHotelViewModel = hotelViewModel;
        notifyDataSetChanged();
    }

    public void setBookedRoomFragment(BookedRoomFragment bookedRoomFragment) {
        this.bookedRoomFragment = bookedRoomFragment;
        notifyDataSetChanged();
    }
}