import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RequestHandler RequestHandler =new RequestHandler();

        System.out.println(RequestHandler.getForecastForData(RequestHandler.getcityID("Saint Petersburg")));
    }
}