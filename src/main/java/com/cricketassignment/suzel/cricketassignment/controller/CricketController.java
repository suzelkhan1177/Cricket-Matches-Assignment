package com.cricketassignment.suzel.cricketassignment.controller;


import com.cricketassignment.suzel.cricketassignment.service.CricketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricketController {

    @Autowired
    private CricketService cricketService;

    @GetMapping("/cricket/results")
    public String getCricketResults() {
        return cricketService.getCricketDataResults();
    }
}