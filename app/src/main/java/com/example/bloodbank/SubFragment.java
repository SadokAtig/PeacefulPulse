package com.example.bloodbank;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class SubFragment extends Fragment {

    private ViewPager2 viewPager2;
    private List<ShortsData> shortsDataList;
    private ShortsAdapter shortsAdapter;


    public SubFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View roootview= inflater.inflate(R.layout.fragment_sub, container, false);
       shortsDataList = new ArrayList<>();
       viewPager2 = roootview.findViewById(R.id.viewpager2);
       shortsDataList.add(new ShortsData("android.resource://"+getActivity().getPackageName()+"/"+R.raw.same ,"@Dr SMART team","Mental Health Reel #shorts #health #mentalhealth ",R.drawable.unnamed));
        shortsAdapter = new ShortsAdapter(shortsDataList);
       viewPager2.setAdapter(shortsAdapter);

       return roootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}