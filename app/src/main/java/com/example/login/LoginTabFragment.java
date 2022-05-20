package com.example.login;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.login.databinding.LoginTabFragmentBinding;

public class LoginTabFragment extends BaseFragment<LoginTabFragmentBinding>{

    @Override
    public LoginTabFragmentBinding bind() {
        return LoginTabFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
