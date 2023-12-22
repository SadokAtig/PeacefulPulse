package com.example.bloodbank;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class AboutFragment extends Fragment {
/*
    CalendarView calendarView ;
    Calendar calendar = null  ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_about, container, false);
        SetData(3,1,2023);
        getData();
        calendarView = rootview.findViewById(R.id.calenderView);
        calendar = Calendar.getInstance();
        
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(getContext(), day +"/"+month+"/"+year , Toast.LENGTH_SHORT).show();
            }
        });










        return rootview ;

    }


    public void getData(){

        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(getContext(),selected_date,Toast.LENGTH_SHORT).show();
    }


    public void SetData(int day , int month , int year){
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        long mili = calendar.getTimeInMillis();
        calendarView.setDate(mili);
    }*/
}