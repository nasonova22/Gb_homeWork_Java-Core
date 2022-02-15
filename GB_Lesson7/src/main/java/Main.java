import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        String name ="London";
        RequestHandler requestHandler =new RequestHandler();
        requestHandler.getForecastForData(requestHandler.getcityID(name));

        try {
            DbWeather dbWeather =new DbWeather();

            dbWeather.addWeatherInfo(requestHandler);
            System.out.println(dbWeather.allWeatherInfo());
            dbWeather.delWeatherInfo(name);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}