package com.cricketassignment.suzel.cricketassignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @JsonProperty("id")
    private String id;

    @JsonProperty("dateTimeGMT")
    private String dateTimeGMT;

    @JsonProperty("matchType")
    private String matchType;

    @JsonProperty("status")
    private String status;

    @JsonProperty("ms")
    private String ms;

    @JsonProperty("t1")
    private String team1;

    @JsonProperty("t2")
    private String team2;

    @JsonProperty("t1s")
    private String team1Score;

    @JsonProperty("t2s")
    private String team2Score;

}
