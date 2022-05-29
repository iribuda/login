package com.example.san.ui.hotelRooms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.FragmentRoomsBinding;
import com.example.san.entities.Hotel;

import java.util.List;

public class HotelsFragment extends Fragment {
    private HotelViewModel hotelViewModel;
    private FragmentRoomsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        hotelViewModel = new ViewModelProvider(this).get(HotelViewModel.class);

        binding = FragmentRoomsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerViewRooms;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.setHasFixedSize(true);

        final HotelAdapter hotelAdapter = new HotelAdapter();
        recyclerView.setAdapter(hotelAdapter);
        hotelViewModel.getAllRoom().observe(requireActivity(), new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {
                hotelAdapter.setRooms(hotels);
                hotelAdapter.setRoomViewModel(hotelViewModel);
                hotelAdapter.setRoomsFragment(HotelsFragment.this);
            }
        });

        return root;

    }
}