package com.example.optimalweather.mwa;

import com.example.optimalweather.DateTimeHelper;
import com.example.optimalweather.api.MyWeatherClass;
import com.example.optimalweather.mwa.entityMWA.Forecast;
import com.example.optimalweather.mwa.entityMWA.Forecastday;
import com.example.optimalweather.mwa.entityMWA.Hour;
import com.example.optimalweather.mwa.entityMWA.WeatherEntityMWA;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class MWAWeatherApiDao {
    WebClient clientMWA = WebClient.create("http://api.weatherapi.com/v1/forecast.json?key=f7a1e12528dd404a87885252240805&q=Stockholm, liljeholmen&days=10&aqi=no&alerts=no");

    public WeatherEntityMWA mwaWeather(){
        Mono<ResponseEntity<WeatherEntityMWA>> answer = clientMWA
                .get()
                .retrieve()
                .toEntity(WeatherEntityMWA.class);
        ResponseEntity<WeatherEntityMWA> responseEntity = answer.block();
        return responseEntity.getBody();
    }

    public MyWeatherClass getWeatherObject(){
        Hour h = getMWAWeatherIn24h();
        double airpressure = h.getPressureMb();
        double temperature = h.getTempC();
        double cloud = h.getHumidity();
        MyWeatherClass myWeatherClass = new MyWeatherClass("WeatherAPI.COM",airpressure,temperature,cloud);
        return myWeatherClass;
    }
    public List<Forecastday> getMWAWeatherForecast(){
        Forecast f = mwaWeather().getForecast();
        return f.getForecastday();
    }
    public Hour getMWAWeatherIn24h(){
        Hour hour = null;
        List<Forecastday> forecastdayList = getMWAWeatherForecast();
        for (Forecastday f : forecastdayList){
            for (Hour h : f.getHour()){
                if (h.getTime().equals(DateTimeHelper.getFormattedTime())){
                    hour = h;
                }
            }
        }
        return hour;
    }
}
