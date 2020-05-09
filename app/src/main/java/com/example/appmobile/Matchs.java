package com.example.appmobile;

import java.util.List;

public class Matchs {

    private String title;
    private String embed;
    private String url;
    private String thumbnail;
    private String date;
    private Side side1;
    private Side side2;
    private Competition competition;
    private List<Video> video;

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
