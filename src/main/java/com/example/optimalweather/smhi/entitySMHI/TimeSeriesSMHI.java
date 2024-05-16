
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
        "validTime",
        "parameters"
})
public class TimeSeriesSMHI {


    @JsonProperty("validTime")
    private String validTime;
    @JsonProperty("parameters")
    private List<Parameter> parameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeSeriesSMHI() {
    }

    /**
     * 
     * @param validTime
     * @param parameters
     */
    public TimeSeriesSMHI(String validTime, List<Parameter> parameters) {
        super();
        this.validTime = validTime;
        this.parameters = parameters;
    }

    @JsonProperty("validTime")
    public String getValidTime() {
        return validTime;
    }

    @JsonProperty("validTime")
    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    @JsonProperty("parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
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
        return "TimeSeriesSMHI{" +
                "validTime='" + validTime + '\'' +
                ", parameters=" + parameters +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
