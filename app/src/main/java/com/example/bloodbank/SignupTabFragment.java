package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupTabFragment extends Fragment {
    Button sign ;
    EditText mail , password, pseudo  ;
    FirebaseDatabase firebaseDatabase ;

    DatabaseReference reference ;

    TextView  loginRedirect ;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup_tab, container, false);

        mail = v.findViewById(R.id.signupemail);
        password = v.findViewById(R.id.signuppassword);
        pseudo = v.findViewById(R.id.signupseudo);
        loginRedirect = v.findViewById(R.id.SignupRedirectText);

        sign = v.findViewById(R.id.signupbutton);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("users");

                String email  = mail.getText().toString();
                String pass = password.getText().toString();
                String pseud = pseudo.getText().toString();
                HelperClass helperClass = new HelperClass(pseud,pass,email);
                reference.child(pseud).setValue(helperClass);
                Toast.makeText(getContext(),"you have signup successfuly",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), LoginTabFragment.class);
                startActivity(intent);
            }
        });


        loginRedirect.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(getContext(), LoginTabFragment.class);
                       startActivity(intent);
                   }
               });


        return v ;






    }



}