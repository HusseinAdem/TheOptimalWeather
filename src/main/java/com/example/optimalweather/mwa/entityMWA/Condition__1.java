
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
    "text",
    "icon",
    "code"
})
public class Condition__1 {

    @JsonProperty("text")
    private String text;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("code")
    private Integer code;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition__1() {
    }

    /**
     * 
     * @param code
     * @param icon
     * @param text
     */
    public Condition__1(String text, String icon, Integer code) {
        super();
        this.text = text;
        this.icon = icon;
        this.code = code;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
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
        return "Condition__1{" +
                "text='" + text + '\'' +
                ", icon='" + icon + '\'' +
                ", code=" + code +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
