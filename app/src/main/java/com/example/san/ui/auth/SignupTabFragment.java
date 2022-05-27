package com.example.san.ui.auth;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.san.databinding.SignupTabFragmentBinding;
import com.example.san.entities.User;
import com.example.san.utils.BaseFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupTabFragment extends BaseFragment<SignupTabFragmentBinding> {

    private static final String TAG = "";
    FirebaseAuth mAuth;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

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

    public void onClickSignUp() {

        if (
                !TextUtils.isEmpty(binding.email.getText().toString()) &&
                        !TextUtils.isEmpty(binding.password.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(binding.email.getText().toString(),
                    binding.password.getText().toString()).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(requireActivity(), "Вы успешо зарегистрировались", Toast.LENGTH_SHORT).show();
                        sendEmailVer();
                        onClickSave();
                    }
                    else{
                        Toast.makeText(requireActivity(), "Вы не зарегистрировались", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener( e->
                    Log.w(TAG, e.getMessage())

            );
        } else {
            Toast.makeText(requireActivity(), "Пожалуйста, введите почту и пароль", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClickSave(){
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);

        String id = mDataBase.getKey();
        String name = binding.name.getText().toString();
        String mobileNum = binding.mobileNum.getText().toString();
        String email = binding.email.getText().toString();
        String date = "";

        User newUser = new User(id, name, mobileNum, email, date);
        mDataBase.push().setValue(newUser);
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
