package com.example.bloodbank;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder> {

     List<ShortsData> shortsDataList ;

     public ShortsAdapter(List<ShortsData> shortsDataList){
         this.shortsDataList = shortsDataList ;
     }

    @NonNull
    @Override
    public ShortsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shorts,parent,false);
        return new ShortsViewHolder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull ShortsViewHolder holder, int position) {
        holder.setShortsData(shortsDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return shortsDataList.size();
    }

    public class ShortsViewHolder extends RecyclerView.ViewHolder{
        VideoView videoView ;
        TextView shortUser , shortTitle ;

        ImageView shortsImage ;
        public ShortsViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            shortUser = itemView.findViewById(R.id.shortsUser);
            shortTitle = itemView.findViewById(R.id.shortsTitle);
            shortsImage = itemView.findViewById(R.id.shortsImage);

        }

        public void setShortsData(ShortsData shortsData){
            shortUser.setText(shortsData.getShortsUser());
            shortTitle.setText(shortsData.getShortsTitle());
            videoView.setVideoPath(shortsData.getShortPath());
            shortsImage.setImageResource(shortsData.getShortsImage());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                        if (mediaPlayer != null) {
                            mediaPlayer.start();
                            float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                            float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                            float scale = videoRatio/screenRatio ;
                            if(scale >=1f){
                                videoView.setScaleX(scale);
                            } else {
                                videoView.setScaleY(1f/scale);
                            }
                        }
                    }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if (mp != null) {
                        mp.start();
                    }
                }
            });

        }
    }
}
