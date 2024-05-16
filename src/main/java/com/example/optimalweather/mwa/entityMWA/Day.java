
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
    "maxtemp_c",
    "maxtemp_f",
    "mintemp_c",
    "mintemp_f",
    "avgtemp_c",
    "avgtemp_f",
    "maxwind_mph",
    "maxwind_kph",
    "totalprecip_mm",
    "totalprecip_in",
    "totalsnow_cm",
    "avgvis_km",
    "avgvis_miles",
    "avghumidity",
    "daily_will_it_rain",
    "daily_chance_of_rain",
    "daily_will_it_snow",
    "daily_chance_of_snow",
    "condition",
    "uv"
})

public class Day {

    @JsonProperty("maxtemp_c")
    private Double maxtempC;
    @JsonProperty("maxtemp_f")
    private Double maxtempF;
    @JsonProperty("mintemp_c")
    private Double mintempC;
    @JsonProperty("mintemp_f")
    private Double mintempF;
    @JsonProperty("avgtemp_c")
    private Double avgtempC;
    @JsonProperty("avgtemp_f")
    private Double avgtempF;
    @JsonProperty("maxwind_mph")
    private Double maxwindMph;
    @JsonProperty("maxwind_kph")
    private Double maxwindKph;
    @JsonProperty("totalprecip_mm")
    private Double totalprecipMm;
    @JsonProperty("totalprecip_in")
    private Double totalprecipIn;
    @JsonProperty("totalsnow_cm")
    private Double totalsnowCm;
    @JsonProperty("avgvis_km")
    private Double avgvisKm;
    @JsonProperty("avgvis_miles")
    private Double avgvisMiles;
    @JsonProperty("avghumidity")
    private Integer avghumidity;
    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain;
    @JsonProperty("daily_chance_of_rain")
    private Integer dailyChanceOfRain;
    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow;
    @JsonProperty("daily_chance_of_snow")
    private Integer dailyChanceOfSnow;
    @JsonProperty("condition")
    private Condition__1 condition;
    @JsonProperty("uv")
    private Double uv;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Day() {
    }

    /**
     * 
     * @param uv
     * @param dailyWillItRain
     * @param dailyChanceOfRain
     * @param avgtempF
     * @param mintempC
     * @param totalprecipMm
     * @param dailyWillItSnow
     * @param totalprecipIn
     * @param avghumidity
     * @param condition
     * @param avgvisKm
     * @param mintempF
     * @param maxwindMph
     * @param maxwindKph
     * @param maxtempF
     * @param dailyChanceOfSnow
     * @param avgtempC
     * @param totalsnowCm
     * @param maxtempC
     * @param avgvisMiles
     */
    public Day(Double maxtempC, Double maxtempF, Double mintempC, Double mintempF, Double avgtempC, Double avgtempF, Double maxwindMph, Double maxwindKph, Double totalprecipMm, Double totalprecipIn, Double totalsnowCm, Double avgvisKm, Double avgvisMiles, Integer avghumidity, Integer dailyWillItRain, Integer dailyChanceOfRain, Integer dailyWillItSnow, Integer dailyChanceOfSnow, Condition__1 condition, Double uv) {
        super();
        this.maxtempC = maxtempC;
        this.maxtempF = maxtempF;
        this.mintempC = mintempC;
        this.mintempF = mintempF;
        this.avgtempC = avgtempC;
        this.avgtempF = avgtempF;
        this.maxwindMph = maxwindMph;
        this.maxwindKph = maxwindKph;
        this.totalprecipMm = totalprecipMm;
        this.totalprecipIn = totalprecipIn;
        this.totalsnowCm = totalsnowCm;
        this.avgvisKm = avgvisKm;
        this.avgvisMiles = avgvisMiles;
        this.avghumidity = avghumidity;
        this.dailyWillItRain = dailyWillItRain;
        this.dailyChanceOfRain = dailyChanceOfRain;
        this.dailyWillItSnow = dailyWillItSnow;
        this.dailyChanceOfSnow = dailyChanceOfSnow;
        this.condition = condition;
        this.uv = uv;
    }

    @JsonProperty("maxtemp_c")
    public Double getMaxtempC() {
        return maxtempC;
    }

    @JsonProperty("maxtemp_c")
    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    @JsonProperty("maxtemp_f")
    public Double getMaxtempF() {
        return maxtempF;
    }

    @JsonProperty("maxtemp_f")
    public void setMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
    }

    @JsonProperty("mintemp_c")
    public Double getMintempC() {
        return mintempC;
    }

    @JsonProperty("mintemp_c")
    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }

    @JsonProperty("mintemp_f")
    public Double getMintempF() {
        return mintempF;
    }

    @JsonProperty("mintemp_f")
    public void setMintempF(Double mintempF) {
        this.mintempF = mintempF;
    }

    @JsonProperty("avgtemp_c")
    public Double getAvgtempC() {
        return avgtempC;
    }

    @JsonProperty("avgtemp_c")
    public void setAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
    }

    @JsonProperty("avgtemp_f")
    public Double getAvgtempF() {
        return avgtempF;
    }

    @JsonProperty("avgtemp_f")
    public void setAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
    }

    @JsonProperty("maxwind_mph")
    public Double getMaxwindMph() {
        return maxwindMph;
    }

    @JsonProperty("maxwind_mph")
    public void setMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    @JsonProperty("maxwind_kph")
    public Double getMaxwindKph() {
        return maxwindKph;
    }

    @JsonProperty("maxwind_kph")
    public void setMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    @JsonProperty("totalprecip_mm")
    public Double getTotalprecipMm() {
        return totalprecipMm;
    }

    @JsonProperty("totalprecip_mm")
    public void setTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    @JsonProperty("totalprecip_in")
    public Double getTotalprecipIn() {
        return totalprecipIn;
    }

    @JsonProperty("totalprecip_in")
    public void setTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    @JsonProperty("totalsnow_cm")
    public Double getTotalsnowCm() {
        return totalsnowCm;
    }

    @JsonProperty("totalsnow_cm")
    public void setTotalsnowCm(Double totalsnowCm) {
        this.totalsnowCm = totalsnowCm;
    }

    @JsonProperty("avgvis_km")
    public Double getAvgvisKm() {
        return avgvisKm;
    }

    @JsonProperty("avgvis_km")
    public void setAvgvisKm(Double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    @JsonProperty("avgvis_miles")
    public Double getAvgvisMiles() {
        return avgvisMiles;
    }

    @JsonProperty("avgvis_miles")
    public void setAvgvisMiles(Double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    @JsonProperty("avghumidity")
    public Integer getAvghumidity() {
        return avghumidity;
    }

    @JsonProperty("avghumidity")
    public void setAvghumidity(Integer avghumidity) {
        this.avghumidity = avghumidity;
    }

    @JsonProperty("daily_will_it_rain")
    public Integer getDailyWillItRain() {
        return dailyWillItRain;
    }

    @JsonProperty("daily_will_it_rain")
    public void setDailyWillItRain(Integer dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public Integer getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public void setDailyChanceOfRain(Integer dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    @JsonProperty("daily_will_it_snow")
    public Integer getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    @JsonProperty("daily_will_it_snow")
    public void setDailyWillItSnow(Integer dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public Integer getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public void setDailyChanceOfSnow(Integer dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    @JsonProperty("condition")
    public Condition__1 getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(Condition__1 condition) {
        this.condition = condition;
    }

    @JsonProperty("uv")
    public Double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
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
        return "Day{" +
                "maxtempC=" + maxtempC +
                ", maxtempF=" + maxtempF +
                ", mintempC=" + mintempC +
                ", mintempF=" + mintempF +
                ", avgtempC=" + avgtempC +
                ", avgtempF=" + avgtempF +
                ", maxwindMph=" + maxwindMph +
                ", maxwindKph=" + maxwindKph +
                ", totalprecipMm=" + totalprecipMm +
                ", totalprecipIn=" + totalprecipIn +
                ", totalsnowCm=" + totalsnowCm +
                ", avgvisKm=" + avgvisKm +
                ", avgvisMiles=" + avgvisMiles +
                ", avghumidity=" + avghumidity +
                ", dailyWillItRain=" + dailyWillItRain +
                ", dailyChanceOfRain=" + dailyChanceOfRain +
                ", dailyWillItSnow=" + dailyWillItSnow +
                ", dailyChanceOfSnow=" + dailyChanceOfSnow +
                ", condition=" + condition +
                ", uv=" + uv +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
