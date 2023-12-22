package com.example.bloodbank;

public class VideoItem {
    private int videoThumbail  ;
    private String videoTitle ;
    private String channelName;



   // private int channelImage ;

    public int getVideoThumbail() {
        return videoThumbail;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getChannelName() {
        return channelName;
    }

   /* public int getChannelImage() {
        return channelImage;
    }*/
//, int channelImage
    public VideoItem(int videoThumbail, String videoTitle, String channelName) {
        this.videoThumbail = videoThumbail;
        this.videoTitle = videoTitle;
        this.channelName = channelName;
      //  this.channelImage = channelImage;
    }
}
