package com.example.optimalweather.smhi;

import com.example.optimalweather.DateTimeHelper;
import com.example.optimalweather.api.MyWeatherClass;
import com.example.optimalweather.smhi.entitySMHI.Parameter;
import com.example.optimalweather.smhi.entitySMHI.TimeSeriesSMHI;
import com.example.optimalweather.smhi.entitySMHI.WeatherEntitySMHI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class SMHIWeatherApiDao {
    @Autowired
    DateTimeHelper dateTimeHelper;
    WebClient clientSMHI = WebClient.create("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/");

    public WeatherEntitySMHI smhiWeather(){
        Mono<ResponseEntity<WeatherEntitySMHI>> answer = clientSMHI
                .get()
                .uri("/data.json")
                .retrieve()
                .toEntity(WeatherEntitySMHI.class);
        ResponseEntity<WeatherEntitySMHI> responseEntity = answer.block();
        return responseEntity.getBody();
    }
    private List<TimeSeriesSMHI> getSMHITimeSeriesList(){
        return smhiWeather().getTimeSeries();
    }
    private TimeSeriesSMHI getSMHIWeatherIn24h(){

        for (TimeSeriesSMHI t : smhiWeather().getTimeSeries()){
            if (DateTimeHelper.compareDateTimeStrings(t.getValidTime())){
                return t;
            }
        }
        return null;
    }
    public MyWeatherClass getWeatherObject(){
        TimeSeriesSMHI t = getSMHIWeatherIn24h();
        Double airpressure = 0.0;
        Double temperature = 0.0;
        Double cloud = 0.0;
        MyWeatherClass myWeatherClass;

        for (Parameter parameter : t.getParameters()){
            System.out.println(parameter);
            if (parameter.getName().equals("msl")){
                airpressure = parameter.getValues().get(0);
            }
            if (parameter.getName().equals("t")){
                System.out.println(parameter.getValues().get(0));
                temperature = parameter.getValues().get(0).doubleValue();
                System.out.println(temperature);
            }
            if (parameter.getName().equals("r")){
                cloud = parameter.getValues().get(0).doubleValue();
            }

        }
        myWeatherClass = new MyWeatherClass("SMHI",airpressure,temperature,cloud);
        return myWeatherClass;

    }


}
