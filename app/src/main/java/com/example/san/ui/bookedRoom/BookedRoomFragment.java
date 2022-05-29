package com.example.san.ui.bookedRoom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.FragmentBookedRoomBinding;
import com.example.san.databinding.FragmentRoomsBinding;
import com.example.san.entities.Hotel;
import com.example.san.ui.hotelRooms.HotelAdapter;
import com.example.san.ui.hotelRooms.HotelViewModel;

import java.util.List;

public class BookedRoomFragment extends Fragment {
    private HotelViewModel hotelViewModel;
    private FragmentBookedRoomBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        hotelViewModel = new ViewModelProvider(this).get(HotelViewModel.class);

        binding = FragmentBookedRoomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerViewBookedRooms;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.setHasFixedSize(true);

        final BookedHotelAdapter adapter = new BookedHotelAdapter();
        recyclerView.setAdapter(adapter);
        hotelViewModel.getReservedRooms().observe(requireActivity(), new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {
                adapter.setRooms(hotels);
                adapter.setRoomViewModel(hotelViewModel);
                adapter.setBookedRoomFragment(BookedRoomFragment.this);
            }
        });
        return root;
    }
}