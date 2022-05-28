package com.example.san.ui.hotelRooms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.FragmentRoomsBinding;
import com.example.san.entities.Hotel;
import com.example.san.ui.bookedRoom.BookedHotelViewModel;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class HotelsFragment extends Fragment {
    private HotelViewModel hotelViewModel;
    private BookedHotelViewModel bookedHotelViewModel;
    private FragmentRoomsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        hotelViewModel = new ViewModelProvider(this).get(HotelViewModel.class);
        bookedHotelViewModel = new ViewModelProvider(this).get(BookedHotelViewModel.class);

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
                hotelAdapter.setBookedHotelViewModel(bookedHotelViewModel);
                hotelAdapter.setRoomsFragment(HotelsFragment.this);
                hotelAdapter.setFragment(getParentFragmentManager());
            }
        });
        return root;
    }
}