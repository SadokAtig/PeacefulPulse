package com.example.bloodbank;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LibraryFragment extends Fragment {
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_library, container, false);
        profileName = v.findViewById(R.id.profileName);
        profileEmail = v.findViewById(R.id.profileEmail);
        profileUsername = v.findViewById(R.id.profileUsername);
        titleName = v.findViewById(R.id.titleName);
        titleUsername = v.findViewById(R.id.titleUsername);
       // showAllUserData();



        return v ;
    }
/*
    public void showAllUserData(){
        Intent intent = getIntent();
        String nameUser = intent.getStringExtra("pseudo");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("password");
        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
    }
*/



}