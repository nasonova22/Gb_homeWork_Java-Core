import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbWeather {
    private static final String PATH_DB = "jdbc:sqlite:D:\\WeatherCity.db";
    private Connection connection;

    public DbWeather() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_DB);
    }

    // add добавить в БД данные о погоде
    public void addWeatherInfo(RequestHandler requestHandler) {
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO InfoWeatherCity(nameCity, temperature, date)" + " VALUES(? ,? ,?)");
            ps.setObject(1, requestHandler.getNameCity());
            ps.setObject(2, requestHandler.getTemperature());
            ps.setObject(3, requestHandler.getDateWeather());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //select вернуть всю таблицу из БД
    public ArrayList allWeatherInfo() {
        ArrayList<RequestHandler> requestHandlers = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM InfoWeatherCity");
            while (rs.next()) {
                String name = rs.getString("nameCity");
                String temp = rs.getString("temperature");
                String date = rs.getString("date");
                RequestHandler requestHandler = new RequestHandler(name, temp, date);
                requestHandlers.add(requestHandler);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (requestHandlers);
    }
    //delete удалить запись по названию города из БД
    public void delWeatherInfo(String name)  {
        try {
            Statement statement = this.connection.createStatement();
            int res = statement.executeUpdate(String.format("DELETE FROM InfoWeatherCity WHERE nameCity='%s'", name));
            System.out.println("Delete records: " + res);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}