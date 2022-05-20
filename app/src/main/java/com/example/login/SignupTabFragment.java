package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login.databinding.SignupTabFragmentBinding;

public class SignupTabFragment extends BaseFragment<SignupTabFragmentBinding> {

    @Override
    public SignupTabFragmentBinding bind() {
        return SignupTabFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
