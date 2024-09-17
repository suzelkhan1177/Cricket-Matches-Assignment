package com.cricketassignment.suzel.cricketassignment.service;

import com.cricketassignment.suzel.cricketassignment.model.CricketApiResponse;
import com.cricketassignment.suzel.cricketassignment.model.Match;
import com.cricketassignment.suzel.cricketassignment.util.CricketDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CricketService {

    private static final Logger logger = LoggerFactory.getLogger(CricketService.class);
    private final String apiUrl = "https://api.cuvora.com/car/partner/cricket-data";
    private final String apiKey = "test-creds@2320";

    public String getCricketDataResults() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<CricketApiResponse> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, CricketApiResponse.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                List<Match> matches = response.getBody().getData();
                logger.info("Received {} matches", matches.size());

                String highestScoreTeam = CricketDataParser.getHighestScoreTeam(matches);
                int matchesWith300PlusScore = CricketDataParser.getMatchesWith300PlusScore(matches);

                return "Highest Score: " + highestScoreTeam + "\nNumber of Matches with total 300 Plus Score: " + matchesWith300PlusScore;
            } else {
                logger.error("Failed to retrieve matches, response status: {}", response.getStatusCode());
                return "Failed to retrieve cricket data.";
            }

        } catch (RestClientException e) {
            logger.error("Error while fetching cricket data", e);
            return "Error occurred while fetching cricket data.";
        }
    }
}
