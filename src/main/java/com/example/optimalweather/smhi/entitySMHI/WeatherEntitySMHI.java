
package com.example.optimalweather.smhi.entitySMHI;

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
        "approvedTime",
        "referenceTime",
        "geometry",
        "timeSeries"
})
public class WeatherEntitySMHI {


    @JsonProperty("approvedTime")
    private String approvedTime;
    @JsonProperty("referenceTime")
    private String referenceTime;
    @JsonProperty("geometry")
    private Geometry geometry;
    @JsonProperty("timeSeries")
    private List<TimeSeriesSMHI> timeSeries;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeatherEntitySMHI() {
    }

    /**
     * 
     * @param timeSeries
     * @param referenceTime
     * @param approvedTime
     * @param geometry
     */
    public WeatherEntitySMHI(String approvedTime, String referenceTime, Geometry geometry, List<TimeSeriesSMHI> timeSeries) {
        super();
        this.approvedTime = approvedTime;
        this.referenceTime = referenceTime;
        this.geometry = geometry;
        this.timeSeries = timeSeries;
    }

    @JsonProperty("approvedTime")
    public String getApprovedTime() {
        return approvedTime;
    }

    @JsonProperty("approvedTime")
    public void setApprovedTime(String approvedTime) {
        this.approvedTime = approvedTime;
    }

    @JsonProperty("referenceTime")
    public String getReferenceTime() {
        return referenceTime;
    }

    @JsonProperty("referenceTime")
    public void setReferenceTime(String referenceTime) {
        this.referenceTime = referenceTime;
    }

    @JsonProperty("geometry")
    public Geometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("timeSeries")
    public List<TimeSeriesSMHI> getTimeSeries() {
        return timeSeries;
    }

    @JsonProperty("timeSeries")
    public void setTimeSeries(List<TimeSeriesSMHI> timeSeries) {
        this.timeSeries = timeSeries;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
