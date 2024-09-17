package com.cricketassignment.suzel.cricketassignment.controller;


import com.cricketassignment.suzel.cricketassignment.service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CricketController {

    @Autowired
    private CricketService cricketService;


    @GetMapping("/cricket/results")
    public ResponseEntity<Map<String, Object>> getCricketResults() {
        Map<String, Object> response = new HashMap<>();
        try {
            String results = cricketService.getCricketDataResults();
            response.put("status", "success");
            response.put("data", results);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error occurred while fetching cricket data.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}