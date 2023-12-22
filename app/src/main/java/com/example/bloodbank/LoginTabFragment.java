package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Base64;


public class LoginTabFragment extends Fragment {
     Button log ;

     EditText pseudo , pas  ;

     TextView textView ;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_login_tab, container, false);
       log = v.findViewById(R.id.login);
       pseudo = v.findViewById(R.id.mailcase);
       pas = v.findViewById(R.id.loginpassword);
       textView = v.findViewById(R.id.loginRedirectText);

       log.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (!validateUsername() | !validatePassword()) {
               } else {
                   checkUser();
               }
           }
       });

       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                   Intent intent = new Intent(getContext(), SignupTabFragment.class);
                   startActivity(intent);
               }

       });

        return v ;

    }


    public Boolean validateUsername() {
        String val = pseudo.getText().toString();
        if (val.isEmpty()) {
            pseudo.setError("Username cannot be empty");
            return false;
        } else {
            pseudo.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = pas.getText().toString();
        if (val.isEmpty()) {
            pas.setError("Password cannot be empty");
            return false;
        } else {
            pas.setError(null);
            return true;
        }
    }

    public void checkUser(){
        String psd = pseudo.getText().toString().trim();
        String password = pas.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("pseudo").equalTo(psd);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    pseudo.setError(null);
                    String passwordFromDB = snapshot.child(psd).child("password").getValue(String.class);
                    if (passwordFromDB != null && passwordFromDB.equals(password)) {
                        pseudo.setError(null);
                        String emailFromDB = snapshot.child(psd).child("pseudo").getValue(String.class);
                        Intent intent = new Intent(getContext(), drawer.class);
                        intent.putExtra("pseudo", emailFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        pas.setError("Invalid Credentials");
                        pas.requestFocus();
                    }
                } else {
                    pseudo.setError("User does not exist");
                    pseudo.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

        }