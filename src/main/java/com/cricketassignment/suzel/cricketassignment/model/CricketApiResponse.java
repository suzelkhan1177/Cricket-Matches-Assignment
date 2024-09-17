package com.cricketassignment.suzel.cricketassignment.model;

import lombok.Data;

import java.util.List;

@Data
public class CricketApiResponse {
    private List<Match> data;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }
}
