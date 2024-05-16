
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
    "sunrise",
    "sunset",
    "moonrise",
    "moonset",
    "moon_phase",
    "moon_illumination",
    "is_moon_up",
    "is_sun_up"
})

public class Astro {

    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("moonrise")
    private String moonrise;
    @JsonProperty("moonset")
    private String moonset;
    @JsonProperty("moon_phase")
    private String moonPhase;
    @JsonProperty("moon_illumination")
    private Integer moonIllumination;
    @JsonProperty("is_moon_up")
    private Integer isMoonUp;
    @JsonProperty("is_sun_up")
    private Integer isSunUp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Astro() {
    }

    /**
     * 
     * @param moonset
     * @param sunrise
     * @param sunset
     * @param isSunUp
     * @param moonrise
     * @param isMoonUp
     * @param moonPhase
     * @param moonIllumination
     */
    public Astro(String sunrise, String sunset, String moonrise, String moonset, String moonPhase, Integer moonIllumination, Integer isMoonUp, Integer isSunUp) {
        super();
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonPhase = moonPhase;
        this.moonIllumination = moonIllumination;
        this.isMoonUp = isMoonUp;
        this.isSunUp = isSunUp;
    }

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("moonrise")
    public String getMoonrise() {
        return moonrise;
    }

    @JsonProperty("moonrise")
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    @JsonProperty("moonset")
    public String getMoonset() {
        return moonset;
    }

    @JsonProperty("moonset")
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    @JsonProperty("moon_phase")
    public String getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moon_phase")
    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("moon_illumination")
    public Integer getMoonIllumination() {
        return moonIllumination;
    }

    @JsonProperty("moon_illumination")
    public void setMoonIllumination(Integer moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    @JsonProperty("is_moon_up")
    public Integer getIsMoonUp() {
        return isMoonUp;
    }

    @JsonProperty("is_moon_up")
    public void setIsMoonUp(Integer isMoonUp) {
        this.isMoonUp = isMoonUp;
    }

    @JsonProperty("is_sun_up")
    public Integer getIsSunUp() {
        return isSunUp;
    }

    @JsonProperty("is_sun_up")
    public void setIsSunUp(Integer isSunUp) {
        this.isSunUp = isSunUp;
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
        return "Astro{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", moonrise='" + moonrise + '\'' +
                ", moonset='" + moonset + '\'' +
                ", moonPhase='" + moonPhase + '\'' +
                ", moonIllumination=" + moonIllumination +
                ", isMoonUp=" + isMoonUp +
                ", isSunUp=" + isSunUp +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
