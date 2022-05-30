package com.example.san.ui.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.san.R;
import com.example.san.ui.info.SettingsFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PatientActivity extends AppCompatActivity implements
        PreferenceFragmentCompat.OnPreferenceStartScreenCallback{

    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    private TextView name, email, date, mobile, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        init();
        getIntentMain();

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        final TextView textTitle = findViewById(R.id.textTitle);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                textTitle.setText(navDestination.getLabel());
            }
        });
    }

    @Override
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat caller, PreferenceScreen pref) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(PreferenceFragmentCompat.ARG_PREFERENCE_ROOT, pref.getKey());
        fragment.setArguments(args);
        ft.replace(R.id.navigation_settings, fragment, pref.getKey());
        ft.addToBackStack(pref.getKey());
        ft.commit();
        return true;
    }

    private void init(){
        name = findViewById(R.id.txt_name);
        email = findViewById(R.id.txt_email);
        date = findViewById(R.id.txt_date);
        mobile = findViewById(R.id.txt_mobile);
        address = findViewById(R.id.txt_address);

        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            name.setText(i.getStringExtra(Constant.USER_NAME));
            email.setText(i.getStringExtra(Constant.USER_EMAIL));
            date.setText(i.getStringExtra(Constant.USER_DATE));
            mobile.setText(i.getStringExtra(Constant.USER_MOBILE));
            address.setText(i.getStringExtra(Constant.USER_ADDRESS));
        }
    }


}