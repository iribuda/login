package com.example.san.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.san.R;
import com.example.san.databinding.FragmentProceduresBinding;
import com.example.san.databinding.FragmentProfileBinding;
import com.example.san.utils.Constant;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileFragment extends Fragment {

    private DatabaseReference mDataBase;
    private String USER_KEY = "User";
    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);

        Intent i = requireActivity().getIntent();
        if (i != null){
            binding.txtName.setText(i.getStringExtra(Constant.USER_NAME));
            binding.txtEmail.setText(i.getStringExtra(Constant.USER_EMAIL));
            binding.dateValue.setText(i.getStringExtra(Constant.USER_DATE));
            binding.mobileValue.setText(i.getStringExtra(Constant.USER_MOBILE));
            binding.addressValue.setText(i.getStringExtra(Constant.USER_ADDRESS));
        }

        return root;
    }
}