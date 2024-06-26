
package com.example.optimalweather.mwa.entityMWA;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "date_epoch",
    "day",
    "astro",
    "hour"
})
public class Forecastday {

    @JsonProperty("date")
    private String date;
    @JsonProperty("date_epoch")
    private Integer dateEpoch;
    @JsonProperty("day")
    private Day day;
    @JsonProperty("astro")
    private Astro astro;
    @JsonProperty("hour")
    private List<Hour> hour;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecastday() {
    }

    /**
     * 
     * @param date
     * @param dateEpoch
     * @param astro
     * @param hour
     * @param day
     */
    public Forecastday(String date, Integer dateEpoch, Day day, Astro astro, List<Hour> hour) {
        super();
        this.date = date;
        this.dateEpoch = dateEpoch;
        this.day = day;
        this.astro = astro;
        this.hour = hour;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("date_epoch")
    public Integer getDateEpoch() {
        return dateEpoch;
    }

    @JsonProperty("date_epoch")
    public void setDateEpoch(Integer dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    @JsonProperty("day")
    public Day getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Day day) {
        this.day = day;
    }

    @JsonProperty("astro")
    public Astro getAstro() {
        return astro;
    }

    @JsonProperty("astro")
    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    @JsonProperty("hour")
    public List<Hour> getHour() {
        return hour;
    }

    @JsonProperty("hour")
    public void setHour(List<Hour> hour) {
        this.hour = hour;
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
        return "Forecastday{" +
                "date='" + date + '\'' +
                ", dateEpoch=" + dateEpoch +
                ", day=" + day +
                ", astro=" + astro +
                ", hour=" + hour +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
