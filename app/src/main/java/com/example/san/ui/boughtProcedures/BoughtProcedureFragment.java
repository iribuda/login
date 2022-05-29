package com.example.san.ui.boughtProcedures;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.san.entities.BoughtProcedure;
import com.example.san.entities.Procedure;
import com.example.san.databinding.FragmentBoughtProceduresBinding;
import com.example.san.ui.procedures.ProcedureViewModel;

import java.util.List;

public class BoughtProcedureFragment extends Fragment {

//    private BoughtProcedureViewModel viewModel;
    private BoughtProcedureViewModel procedureViewModel;
    private FragmentBoughtProceduresBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        viewModel = new ViewModelProvider(this).get(BoughtProcedureViewModel.class);
        procedureViewModel = new ViewModelProvider(this).get(BoughtProcedureViewModel.class);

        binding = FragmentBoughtProceduresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.setHasFixedSize(true);

        final BoughtProcedureAdapter adapter = new BoughtProcedureAdapter();
        recyclerView.setAdapter(adapter);
        procedureViewModel.getAllBoughtProcedures().observe(requireActivity(), new Observer<List<BoughtProcedure>>() {
            @Override
            public void onChanged(List<BoughtProcedure> boughtProcedures) {
                adapter.setBoughtProcedures(boughtProcedures);
                adapter.setBoughtProceduresViewModel(procedureViewModel);
                adapter.setBoughtProceduresFragment(BoughtProcedureFragment.this);
            }
        });

//        final BoughtProcedureAdapter adapter = new BoughtProcedureAdapter();
//        recyclerView.setAdapter(adapter);
//        viewModel.getAllBoughtProcedures().observe(requireActivity(), new Observer<List<BoughtProcedure>>() {
//            @Override
//            public void onChanged(List<BoughtProcedure> boughtProcedures) {
//                adapter.setBoughtProcedures(boughtProcedures);
//            }
//        });

        return root;
    }
}