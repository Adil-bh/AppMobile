package com.example.appmobile.presentation.model;

import com.example.appmobile.presentation.model.Competition;
import com.example.appmobile.presentation.model.Side;
import com.example.appmobile.presentation.model.Video;

import java.util.List;

public class Matchs {

    private String title;
    private String embed;
    private String url;
    private String urlVideo;
    private String thumbnail;
    private String date;
    public Side side1;
    public Side side2;
    private Competition competition;
    public List<Video> video;

    public Matchs() {
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public String getTitle() {
        return title;
    }

    public String getEmbed() {
        return embed;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDate() {
        return date;
    }

    public Side getSide1() {
        return side1;
    }

    public Side getSide2() {
        return side2;
    }

    public Competition getCompetition() {
        return competition;
    }

    public List<Video> getVideo() {
        return video;
    }
}
