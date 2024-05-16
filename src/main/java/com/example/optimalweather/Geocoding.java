package com.example.optimalweather;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;

public class Geocoding {

    private static final String GEOCODING_URL = "https://nominatim.openstreetmap.org/search";
    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/reverse";
    private static final String FORMAT = "json";
    private static final String ACCEPT_LANGUAGE = "sv,eng"; // Språkkod för svenska
    String city;
    String county;
    String suburb;

    public Geocoding(String location) throws IOException {
        this.city = getNoMatter(location)[0];
        this.county = getNoMatter(location)[1];
        this.suburb = getNoMatter(location)[2];
    }

    public static String getCoordinatesByLocation(String location) throws IOException {
        return getCoordinates(location);
    }
    public static String[] getLocationByCoordinates(String coordinates) throws IOException {

        return getLocationDetails(coordinates);
    }
    public static String[] getNoMatter(String location) throws IOException {
        try {
            if (location.matches("^(?:[^0-9]*[A-Za-z]){6,}[^0-9]*$")){
                return getLocationDetails(getCoordinatesByLocation(location));
            } else {
                return getLocationByCoordinates(location);
            }
        } catch (IOException e) {
            return new String[] {"n/a"};
        }

    }

    public void setParameters(){


    }


    public static String[] getLocationDetails(String coordinates) throws IOException {
        String[] parts = coordinates.split(",");
        double lat = Double.parseDouble(parts[0]);
        double lon = Double.parseDouble(parts[1]);
        System.out.println("heej" + lat + lon);
        String response;
        JsonNode jsonNode;
        // Hämta platsinformation baserat på latitud och longitud
        response = getReverseGeocodingResponse(lat, lon);
        ObjectMapper objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readTree(response);
        if (jsonNode.get(0) == null){
            response = getReverseGeocodingResponse(lon, lat);
            jsonNode = objectMapper.readTree(response);
        }
        System.out.println(response);
        if (response != null) {

            String suburb = jsonNode.get("address").get("suburb") != null ? jsonNode.get("address").get("suburb").asText() : "n/a";
            String city = jsonNode.get("address").get("city") != null ? jsonNode.get("address").get("city").asText() : "n/a";
            String county = jsonNode.get("address").get("county") != null ? jsonNode.get("address").get("county").asText() : "n/a";
            //saveLocation(city, county, suburb);
            return new String[]{city, county, suburb};
        } else {
            // Fel vid hämtning av platsinformation
            System.out.println("Failed to retrieve location information for coordinates: " + lat + ", " + lon);
            return null;
        }
    }




    // Metod för att hämta platsinformation baserat på latitud och longitud
    private static String getReverseGeocodingResponse(double lat, double lon) {
        String url = String.format("%s?format=%s&lat=%f&lon=%f&accept-language=%s", NOMINATIM_URL, FORMAT, lat, lon, ACCEPT_LANGUAGE);
        return makeRequest(url);
    }

    // Gemensam metod för att göra HTTP-anrop
    private static String makeRequest(String url) {
        WebClient webClient = WebClient.create();
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }




    // Hämta koordinater för ett platsnamn
    private static String getCoordinates(String location) throws IOException {
        // Skapa URL för geokodning
        String url = String.format("%s?q=%s&format=%s&limit=1", GEOCODING_URL, location, FORMAT);

        // Skicka förfrågan till Nominatim API
        String response = makeRequest(url);

        // Analysera JSON-svaret för att hämta koordinaterna
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response).get(0);

        Double lat = null;
        Double lon = null;

        // Försök tolka som lat,lon
        if (jsonNode.has("lat") && jsonNode.has("lon")) {
            lat = jsonNode.get("lat").asDouble();
            lon = jsonNode.get("lon").asDouble();
        } else {
            // Försök tolka som lon,lat
            if (jsonNode.has("lon") && jsonNode.has("lat")) {
                lon = jsonNode.get("lon").asDouble();
                lat = jsonNode.get("lat").asDouble();
            }
        }


        return String.format("%f,%f", lat, lon);
    }




    public static void main(String[] args) throws IOException {
        // Exempel på inmatning i formatet lat,lon
        String location1 = "59.3110,18.0300";

        // Exempel på inmatning i formatet lon,lat
        //String location2 = "18.0300,59.3110";

        // Exempel på inmatning som platsnamn
        String location3 = "sardinien";

        //String locationDetails1 = getLocationDetails(location1);
        //String locationDetails2 = getLocationDetails(location2);
        //String locationDetails3 = getLocationDetails(location3);

        //System.out.println("Platsinformation från formatet lat,lon: " + locationDetails1);
        //System.out.println("Platsinformation från formatet lon,lat: " + locationDetails2);
        //System.out.println("Platsinformation från platsnamn: " + locationDetails3);
        System.out.println("via platsnamn" + getCoordinatesByLocation("stockholm"));
        System.out.println("via kordinater" + Arrays.toString(getLocationByCoordinates(getCoordinates("59.325117,18.071094"))));
       // Geocoding g = new Geocoding("alghero");
       // System.out.println(g);
    }

    @Override
    public String toString() {
        return "Geocoding{" +
                "city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", suburb='" + suburb + '\'' +
                '}';
    }
}
