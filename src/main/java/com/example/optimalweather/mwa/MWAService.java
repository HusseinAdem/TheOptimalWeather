package com.example.optimalweather.mwa;

import com.example.optimalweather.WeatherProvider;
import com.example.optimalweather.api.MyWeatherClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MWAService implements WeatherProvider {
    @Autowired
    MWAWeatherApiDao mwaWeatherApi;
    @Override
    public double getTemperatureIn24h() {
        return getWeatherObject().getTemperature();
    }

    @Override
    public double getAirpressureIn24h() {
        return getWeatherObject().getAirpressure();
    }

    @Override
    public double getCloudIn24h() {
        return getWeatherObject().getCloud();
    }

    @Override
    public MyWeatherClass getWeatherObject(){
        return mwaWeatherApi.getWeatherObject();
    }
}
