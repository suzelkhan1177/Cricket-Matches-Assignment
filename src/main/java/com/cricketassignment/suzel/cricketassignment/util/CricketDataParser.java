package com.cricketassignment.suzel.cricketassignment.util;



import com.cricketassignment.suzel.cricketassignment.model.Match;

import java.util.List;

public class CricketDataParser {

    public static String getHighestScoreTeam(List<Match> matches) {
        int highestScore = 0;
        String teamName = "";

        for (Match match : matches) {
            int t1Score = parseScore(match.getTeam1Score());
            int t2Score = parseScore(match.getTeam2Score());

            if (t1Score > highestScore) {
                highestScore = t1Score;
                teamName = match.getTeam1();
            }

            if (t2Score > highestScore) {
                highestScore = t2Score;
                teamName = match.getTeam2();
            }
        }

        return highestScore + " by " + teamName;
    }

    public static int getMatchesWith300PlusScore(List<Match> matches) {
        int count = 0;

        for (Match match : matches) {
            int t1Score = parseScore(match.getTeam1Score());
            int t2Score = parseScore(match.getTeam2Score());

            if ((t1Score + t2Score) > 300) {
                count++;
            }
        }

        return count;
    }

    private static int parseScore(String score) {
        if (score == null || score.isEmpty() || score.equals("DNB")) {
            return 0;
        }

        try {
            String[] parts = score.split("/");
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}