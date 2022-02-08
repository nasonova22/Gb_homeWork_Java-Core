import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.math.RoundingMode;


public class RequestHandler {

        static OkHttpClient okHttpClient = new OkHttpClient();
        static ObjectMapper objectMapper = new ObjectMapper();

        public static String getcityID(String nameCity) throws IOException {
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
        public static String getForecastForData(String cityID) throws IOException {
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
            String date = contents.get("Headline").get("EffectiveDate").asText();
            String weatherText = contents.get("Headline").get("Text").asText();
            temperatureMin=Math.ceil((temperatureMin-32.0)/1.8);
            temperatureMax=Math.ceil((temperatureMax-32.0)/1.8);

            String weatherStr= "Date: "+date.substring(0,10)+"  Max t: "+ temperatureMax+"  Min t: "+ temperatureMin+"  WeatherText: "+ weatherText;
            return weatherStr;
        }
    }

