
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
    "name",
    "region",
    "country",
    "lat",
    "lon",
    "tz_id",
    "localtime_epoch",
    "localtime"
})
public class Location {

    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private String region;
    @JsonProperty("country")
    private String country;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("tz_id")
    private String tzId;
    @JsonProperty("localtime_epoch")
    private Integer localtimeEpoch;
    @JsonProperty("localtime")
    private String localtime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param localtime
     * @param country
     * @param tzId
     * @param localtimeEpoch
     * @param name
     * @param lon
     * @param region
     * @param lat
     */
    public Location(String name, String region, String country, Double lat, Double lon, String tzId, Integer localtimeEpoch, String localtime) {
        super();
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tzId = tzId;
        this.localtimeEpoch = localtimeEpoch;
        this.localtime = localtime;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @JsonProperty("tz_id")
    public String getTzId() {
        return tzId;
    }

    @JsonProperty("tz_id")
    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    @JsonProperty("localtime_epoch")
    public Integer getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    @JsonProperty("localtime_epoch")
    public void setLocaltimeEpoch(Integer localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    @JsonProperty("localtime")
    public String getLocaltime() {
        return localtime;
    }

    @JsonProperty("localtime")
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
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
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", tzId='" + tzId + '\'' +
                ", localtimeEpoch=" + localtimeEpoch +
                ", localtime='" + localtime + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
