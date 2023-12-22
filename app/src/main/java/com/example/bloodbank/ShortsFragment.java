package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bloodbank.databinding.ActivityDetailedBinding;

import java.util.ArrayList;
import java.util.List;


public class ShortsFragment extends Fragment {

    public ShortsFragment(){}

    private List<VideoItem> videolist ;
    private RecyclerView homeRecyclerView ;
    private VideoAdapter videoAdapter ;

    ActivityDetailedBinding binding;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_shorts, container, false);
        videolist = generateVideoItems();
        homeRecyclerView  = rootview.findViewById(R.id.RecyclerView);
        homeRecyclerView .setLayoutManager(new LinearLayoutManager(getContext()));
        videoAdapter = new VideoAdapter(videolist);
        homeRecyclerView.setAdapter(videoAdapter);

        return rootview ;
    }

    private List<VideoItem> generateVideoItems() {
        List<VideoItem> videoItems = new ArrayList<>();
        videoItems.add(new VideoItem(R.drawable.p,"Technological Innovations","Mental Health"));
        videoItems.add(new VideoItem(R.drawable.game,"Before I Forget","Games"));
        videoItems.add(new VideoItem(R.drawable.m,"Virtual Reality Therapy","AI"));
        videoItems.add(new VideoItem(R.drawable.music,"Mindfulness ","Music"));
        videoItems.add(new VideoItem(R.drawable.nature,"Nature and Mental Health","Nature"));
        videoItems.add(new VideoItem(R.drawable.mind,"Mind-Body Exercises","Workout"));
        videoItems.add(new VideoItem(R.drawable.course,"Coursera","courses"));
        videoItems.add(new VideoItem(R.drawable.com,"Mental Communication ","Stats"));

        return videoItems;
    }


    // R.drawable.check_detail R.drawable.date_detail R.drawable.ws


}