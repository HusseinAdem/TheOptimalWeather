package com.example.optimalweather.api.controller;

import com.example.optimalweather.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/optimal_hussein")
public class MyRestController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/best")
    public ResponseEntity<?> getBestWeather(){

        return ResponseEntity.accepted().body(weatherService.getBestWeather());
    }
}
