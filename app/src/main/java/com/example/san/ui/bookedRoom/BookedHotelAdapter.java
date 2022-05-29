package com.example.san.ui.bookedRoom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.RoomItemBinding;
import com.example.san.entities.Hotel;
import com.example.san.ui.hotelRooms.HotelViewModel;
import com.example.san.ui.hotelRooms.HotelsFragment;

import java.util.ArrayList;
import java.util.List;

public class BookedHotelAdapter extends RecyclerView.Adapter<BookedHotelAdapter.RoomHolder>{
    private List<Hotel> reservedHotels = new ArrayList<>();
    private HotelViewModel hotelViewModel;
    private BookedRoomFragment bookedRoomFragment;

    @NonNull
    @Override
    public BookedHotelAdapter.RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RoomItemBinding binding = RoomItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BookedHotelAdapter.RoomHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookedHotelAdapter.RoomHolder holder, int position) {
        Hotel hotel = reservedHotels.get(position);

        holder.binding.hotelName.setText(hotel.getName());
        holder.binding.hotelImage.setImageResource(hotel.getPhotoResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(pos != RecyclerView.NO_POSITION){
                    String message = reservedHotels.get(pos).getName() + ", позиция в листе - " + pos;
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.itemView.setOnLongClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(holder.itemView.getContext()).setMessage("Вы хотите удалить")
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int pos) {
//                            hotelViewModel.delete(hotel);
                            hotel.setIsReserved(0);
                            hotelViewModel.update(hotel);
                            String message = "Комната " + hotel.getName() + " была удалена.";
                            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("НЕТ", null).create();
            alertDialog.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return reservedHotels.size();
    }

    public static class RoomHolder extends RecyclerView.ViewHolder {
        RoomItemBinding binding;

        public RoomHolder(@NonNull RoomItemBinding roomItemBinding) {
            super(roomItemBinding.getRoot());
            this.binding = roomItemBinding;
        }
    }

    public void setRooms(List<Hotel> hotels){
        this.reservedHotels = hotels;
        notifyDataSetChanged();
    }

    public void setRoomViewModel(HotelViewModel hotelViewModel){
        this.hotelViewModel = hotelViewModel;
        notifyDataSetChanged();
    }

    public void setBookedRoomFragment(BookedRoomFragment bookedRoomFragment) {
        this.bookedRoomFragment = bookedRoomFragment;
        notifyDataSetChanged();
    }
}