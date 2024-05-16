package com.example.optimalweather;

import com.example.optimalweather.api.MyWeatherClass;

public interface WeatherProvider {
    double getTemperatureIn24h();
    double getAirpressureIn24h();
    double getCloudIn24h();

    MyWeatherClass getWeatherObject();
}
