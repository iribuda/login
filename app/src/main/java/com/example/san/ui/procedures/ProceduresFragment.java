package com.example.san.ui.procedures;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.san.databinding.FragmentProceduresBinding;
import com.example.san.entities.Procedure;
import com.example.san.ui.boughtProcedures.BoughtProcedureViewModel;

import java.util.List;

public class ProceduresFragment extends Fragment {

    private ProcedureViewModel procedureViewModel;
    private BoughtProcedureViewModel boughtProcedureviewModel;
    private FragmentProceduresBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        procedureViewModel = new ViewModelProvider(this).get(ProcedureViewModel.class);
        boughtProcedureviewModel = new ViewModelProvider(this).get(BoughtProcedureViewModel.class);

        binding = FragmentProceduresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerViewProcedure;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
        recyclerView.setHasFixedSize(true);

        final ProcedureAdapter procedureAdapter = new ProcedureAdapter();
        recyclerView.setAdapter(procedureAdapter);
        procedureViewModel.getAllProcedure().observe(requireActivity(), new Observer<List<Procedure>>() {
            @Override
            public void onChanged(List<Procedure> procedures) {
                procedureAdapter.setProcedures(procedures);
                procedureAdapter.setProcedureViewModel(procedureViewModel);
                procedureAdapter.setProceduresFragment(ProceduresFragment.this);
                procedureAdapter.setBoughtProcedureViewModel(boughtProcedureviewModel);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}