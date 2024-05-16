package com.example.optimalweather.api;

import com.example.optimalweather.Geocoding;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class MyWeatherClass {
    String origin;
    LocalDateTime timestamp;
    double airpressure;
    double temperature;
    double cloud;
    Geocoding geocoding;

    public MyWeatherClass(String institute, double airpressure, double temperature, double cloud) {
        this.origin = institute;
        this.timestamp = LocalDateTime.now().plusHours(24).truncatedTo(ChronoUnit.MINUTES);
        this.airpressure = airpressure;
        this.temperature = temperature;
        this.cloud = cloud;

    }

    public MyWeatherClass() {

    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getAirpressure() {
        return airpressure;
    }

    public void setAirpressure(double airpressure) {
        this.airpressure = airpressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }


    public double getCloud() {
        return cloud;
    }

    public void setCloud(double cloud) {
        this.cloud = cloud;
    }

    public Geocoding getGeocoding() {
        return geocoding;
    }

    public void setGeocoding(Geocoding geocoding) {
        this.geocoding = geocoding;
    }

    @Override
    public String toString() {
        return "MyWeatherClass{" +
                "origin='" + origin + '\'' +
                ", timestamp=" + timestamp +
                ", airpressure=" + airpressure +
                ", temperature=" + temperature +
                ", cloud=" + cloud +
                ", geocoding=" + geocoding +
                '}';
    }
}
