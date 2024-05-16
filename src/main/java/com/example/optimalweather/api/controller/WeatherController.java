package com.example.optimalweather.api.controller;

import com.example.optimalweather.api.service.WeatherService;
import com.example.optimalweather.api.MyWeatherClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;


   /* @GetMapping("smhi_weather")
    public String getSMHIWeather(Model model){
        List<TimeSeriesSMHI> list = weatherService.getSMHIWeatherList();
        System.out.println("smhi " + list);
        model.addAttribute("weather1", list);
        return "smhi_forecast";
    }
    @GetMapping("met_weather")
    public String getMETWeather(Model model){
        List<TimeSeriesMET> list = weatherService.getMETWeatherList();
        model.addAttribute("weather1", list);
        return "met_forecast";
    }*/
    @GetMapping("smhi_weather_in_24h")
    public String getSMHIWeatherIn24h(Model model){

        model.addAttribute("weather1", weatherService.getSMHIdataIn24H());
        return "forecast_in_24h";
    }
    @GetMapping("met_weather_in_24h")
    public String getMETWeatherIn24h(Model model){

        model.addAttribute("weather1", weatherService.getMETdataIn24H());
        return "forecast_in_24h";
    }

    @GetMapping("mwa_weather_in_24h")
    public String getMWAWeatherIn24h(Model model){
        model.addAttribute("weather1", weatherService.getMWAdataIn24H());
        return "forecast_in_24h";
    }
    @GetMapping("optimal")
    public String getBestWeather(Model model){
        //MyWeatherClass result = weatherService.getBestWeather();
        model.addAttribute("weather1",weatherService.sortedWeatherObjectsByTemperature());
        return "optimal_forecast";

    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
   /* @GetMapping("mwa_weather")
    public String getMWAWeather(Model model){
        model.addAttribute("weather2",weatherService.getMWAWeatherForecast());

        return "mwa_forecast";

    }
    */

}
