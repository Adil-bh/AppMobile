package com.example.appmobile;

import java.util.List;

public class RestMatchResponse {

    private String type;
    private String format;
    private Integer version;
    private List<Matchs> results;

    public String getType() {
        return type;
    }

    public String getFormat() {
        return format;
    }

    public Integer getVersion() {
        return version;
    }

    public List<Matchs> getResults() {
        return results;
    }
}
