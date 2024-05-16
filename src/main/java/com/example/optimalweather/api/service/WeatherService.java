package com.example.optimalweather.api.service;

import com.example.optimalweather.WeatherProvider;
import com.example.optimalweather.met.METService;
import com.example.optimalweather.mwa.MWAService;
import com.example.optimalweather.api.MyWeatherClass;
import com.example.optimalweather.smhi.SMHIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    SMHIService smhiService;
    @Autowired
    METService metService;
    @Autowired
    MWAService mwaService;




    public MyWeatherClass getBestWeather(){
        return bestWeatherService();
    }
    public MyWeatherClass bestWeatherService() {
        List<WeatherProvider> weatherProviders = Arrays.asList(smhiService, metService, mwaService);

        double highestTemperature = Double.NEGATIVE_INFINITY;
        WeatherProvider providerWithHighestTemperature = null;

        for (WeatherProvider provider : weatherProviders) {
            double temperature = getHighestTemperature(provider);
            if (temperature > highestTemperature) {
                highestTemperature = temperature;
                providerWithHighestTemperature = provider;
            }
        }

        if (providerWithHighestTemperature != null) {
            System.out.println("Temperaturen från " + providerWithHighestTemperature.getClass().getSimpleName() + " är högst.");
            System.out.println("lista med vädertjänser: " + weatherProviders);
            return getWeatherObject(providerWithHighestTemperature);
        } else {
            System.out.println("Det finns ingen tydlig högsta temperatur bland tjänsterna.");
            return null;
        }
    }
    public List<MyWeatherClass> sortedWeatherObjectsByTemperature() {
        List<WeatherProvider> weatherProviders = Arrays.asList(smhiService, metService, mwaService);

        List<MyWeatherClass> weatherObjects = new ArrayList<>();

        Comparator<WeatherProvider> temperatureComparator = Comparator.comparingDouble(this::getHighestTemperature);

        weatherProviders.sort(temperatureComparator.reversed());

        for (WeatherProvider provider : weatherProviders) {
            weatherObjects.add(getWeatherObject(provider));
        }

        return weatherObjects;
    }
    public double getHighestTemperature(WeatherProvider weathers){
        return weathers.getTemperatureIn24h();
    }

    //EXTRA METODER UTÖVER LABBKRAV
    public MyWeatherClass getMETdataIn24H(){
        return getWeatherObject(metService);
    }
    public MyWeatherClass getSMHIdataIn24H(){
        return getWeatherObject(smhiService);
    }
    public MyWeatherClass getMWAdataIn24H(){
        return getWeatherObject(mwaService);
    }
    public MyWeatherClass getWeatherObject(WeatherProvider weathers){
        return weathers.getWeatherObject();
    }





    /*public Object getBestWeather(){
        int valueSMHI = 0;
        for (Parameter p : getSMHIWeatherIn24h().getParameters()){
            if (p.getName().equals("t")){
               valueSMHI = p.getValues().get(0);
            }
        }
        if (valueSMHI > getMetWeatherIn24h().getData().getInstant().getDetails().getAirTemperature()){
            return getSMHIWeatherIn24h();
        } else {
            return getMetWeatherIn24h();
        }

    }
    public MyWeatherClass returnNewEntity(){
        Double airpressure = 0.0;
        Double temperature = 0.0;
        Double cloud = 0.0;
        MyWeatherClass myWeatherClass = null;
        Object bestWeather = getBestWeather();
        if (bestWeather instanceof TimeSeriesSMHI){

            TimeSeriesSMHI ts = (TimeSeriesSMHI) getBestWeather();
            LocalDateTime time = LocalDateTime.parse(ts.getValidTime(), DateTimeFormatter.ISO_DATE_TIME);

            for (Parameter parameter : ts.getParameters()){
                if (parameter.getName().equals("msl")){
                    airpressure = Double.valueOf(parameter.getValues().get(0));
                }
                if (parameter.getName().equals("t")){
                    temperature = Double.valueOf(parameter.getValues().get(0));
                }
                if (parameter.getName().equals("tcc_mean")){
                    cloud = Double.valueOf(parameter.getValues().get(0));
                }

            }

            myWeatherClass = new MyWeatherClass(time,airpressure,temperature,cloud);

        } else if (bestWeather instanceof TimeSeriesMET){
            TimeSeriesMET tm = (TimeSeriesMET) getBestWeather();
            LocalDateTime time = LocalDateTime.parse(tm.getTime(), DateTimeFormatter.ISO_DATE_TIME);

            airpressure = tm.getData().getInstant().getDetails().getAirPressureAtSeaLevel();
            temperature = tm.getData().getInstant().getDetails().getAirTemperature();
            cloud = tm.getData().getInstant().getDetails().getCloudAreaFraction();
            myWeatherClass = new MyWeatherClass(time,airpressure,temperature,cloud);
        }

        return myWeatherClass;


    }*/

}
