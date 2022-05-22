package com.example.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.login.databinding.SignupTabFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupTabFragment extends BaseFragment<SignupTabFragmentBinding> {

    FirebaseAuth mAuth;

    @Override
    public SignupTabFragmentBinding bind() {
        return SignupTabFragmentBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUp();
            }
        });
    }

    public void onClickSignUp(){
        if (
        !TextUtils.isEmpty(binding.email.getText().toString()) &&
        !TextUtils.isEmpty(binding.password.getText().toString())){
            mAuth.createUserWithEmailAndPassword(binding.email.toString(),
                    binding.password.toString()).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(requireActivity(), "You successfully signed up", Toast.LENGTH_SHORT).show();
                        sendEmailVer();
                    }
                    else{
                        Toast.makeText(requireActivity(), "You did not signed up", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(requireActivity(), "Please enter email and password", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendEmailVer(){
        FirebaseUser user = mAuth.getCurrentUser();
        assert user!= null;
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(requireActivity(), "Проверьте вашу почту для подтверждения!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(requireActivity(), "Ошибочка :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
