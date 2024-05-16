
package com.example.optimalweather.mwa.entityMWA;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "location",
    "current",
    "forecast"
})

public class WeatherEntityMWA {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("current")
    private Current current;
    @JsonProperty("forecast")
    private Forecast forecast;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherEntityMWA() {
    }

    /**
     * 
     * @param current
     * @param location
     * @param forecast
     */
    public WeatherEntityMWA(Location location, Current current, Forecast forecast) {
        super();
        this.location = location;
        this.current = current;
        this.forecast = forecast;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("current")
    public Current getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Current current) {
        this.current = current;
    }

    @JsonProperty("forecast")
    public Forecast getForecast() {
        return forecast;
    }

    @JsonProperty("forecast")
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "WeatherEntityMWA{" +
                "location=" + location +
                ", current=" + current +
                ", forecast=" + forecast +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
