package com.cricketassignment.suzel.cricketassignment.model;

import java.util.List;

public class CricketApiResponse {
    private List<Match> data;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }
}
