package com.example.optimalweather.met;

import com.example.optimalweather.DateTimeHelper;
import com.example.optimalweather.api.MyWeatherClass;
import com.example.optimalweather.met.entityMET.TimeSeriesMET;
import com.example.optimalweather.met.entityMET.WeatherEntityMET;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class METWeatherApiDao {
    WebClient clientMET = WebClient.create("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300");

    public WeatherEntityMET metWeather(){
        Mono<ResponseEntity<WeatherEntityMET>> answer = clientMET
                .get()
                .retrieve()
                .toEntity(WeatherEntityMET.class);
        ResponseEntity<WeatherEntityMET> responseEntity = answer.block();
        return responseEntity.getBody();
    }

    private TimeSeriesMET getMetWeatherIn24h(){


        for (TimeSeriesMET timeseries : getMETWeatherList()){

            if (DateTimeHelper.compareDateTimeStrings(timeseries.getTime())){
                return timeseries;
            }
        }
        System.out.println("hej");
        return null;
        //List<TimeSeriesSMHI> timeSeriesSMHIList = getBestWeatherByCelsius();
    }
    private List<TimeSeriesMET> getMETWeatherList(){
        return metWeather().getProperties().getTimeseries();
    }

    public MyWeatherClass getWeatherObject(){
        TimeSeriesMET t = getMetWeatherIn24h();
        double airpressure = t.getData().getInstant().getDetails().getAirPressureAtSeaLevel();
        double temperature = t.getData().getInstant().getDetails().getAirTemperature();
        double cloud = t.getData().getInstant().getDetails().getRelativeHumidity();
        return new MyWeatherClass("MET",airpressure,temperature,cloud);
    }
}
