import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.math.RoundingMode;


public class RequestHandler {
        String nameCity;
        String dateWeather;
        String temperature;

        static OkHttpClient okHttpClient = new OkHttpClient();
        static ObjectMapper objectMapper = new ObjectMapper();

    public RequestHandler() {
    }

    public RequestHandler(String nameCity, String dateWeather, String temperature) {
        this.nameCity = nameCity;
        this.dateWeather = dateWeather;
        this.temperature = temperature;
    }


    public String getNameCity() {
        return nameCity;
    }

    public String getDateWeather() {
        return dateWeather;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "RequestHandler{" +
                "nameCity='" + nameCity + '\'' +
                ", dateWeather='" + dateWeather + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }

    public  String getcityID(String nameCity) throws IOException {
            this.nameCity=nameCity;
            HttpUrl httpUrl = new HttpUrl.Builder().scheme("http")
                    .host("dataservice.accuweather.com")
                    .addPathSegment("locations")
                    .addPathSegment("v1")
                    .addPathSegment("cities")
                    .addPathSegment("search")
                    .addQueryParameter("apikey", "LXtueCtDfkIjfIS85aEvJjNAbl2FfHwf" )
                    .addQueryParameter("q", nameCity).build();

            Request request = new Request.Builder()
                    .addHeader("Accept", "application/json")
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String jsonString = response.body().string();
            String cityID = objectMapper.readTree(jsonString).get(0).at("/Key").asText();
            return cityID;
        }
        public  String getForecastForData(String cityID) throws IOException {
            HttpUrl httpUrl = new HttpUrl.Builder().scheme("http")
                    .host("dataservice.accuweather.com")
                    .addPathSegment("forecasts")
                    .addPathSegment("v1")
                    .addPathSegment("daily")
                    .addPathSegment("1day")
                    .addPathSegment(cityID)
                    .addQueryParameter("apikey", "LXtueCtDfkIjfIS85aEvJjNAbl2FfHwf" ).build();
            Request request = new Request.Builder()
                    .addHeader("Accept", "application/json")
                    .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String jsonString = response.body().string();
            JsonNode contents = objectMapper.readTree(jsonString);

            double temperatureMin = contents.get("DailyForecasts").get(0).get("Temperature").get("Minimum").get("Value").floatValue();
            double temperatureMax = contents.get("DailyForecasts").get(0).get("Temperature").get("Maximum").get("Value").floatValue();
            temperatureMin=Math.ceil((temperatureMin-32.0)/1.8);
            temperatureMax=Math.ceil((temperatureMax-32.0)/1.8);
            this.temperature= String.valueOf("Max t: "+temperatureMax+"  Min t: "+ temperatureMin);
            String date = contents.get("DailyForecasts").get(0).get("Date").asText();
            this.dateWeather=date.substring(0,10);
            String weatherStr= this.dateWeather+this.temperature;
            return weatherStr;
        }
    }




