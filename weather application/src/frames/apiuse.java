package frames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class apiuse {
     String API_KEY = "191f0a12c7b20fcb0c21511f066590a5";
     String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    String CITY_NAME;
    String temperature;
    String humidity;
    String windSpeed;

    public  void retrieveWeatherData() {
        try {
            String apiUrl = API_URL + CITY_NAME + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Set the API key in the request headers if required
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the response and extract the required data
                 temperature = parseTemperature(response.toString());
                 humidity = parseHumidity(response.toString());
                 windSpeed = parseWindSpeed(response.toString());

                // Do something with the weather data
                System.out.println("Temperature: " + temperature);
                System.out.println("Humidity: " + humidity);
                System.out.println("Wind Speed: " + windSpeed);
            } else {
                System.out.println("Error: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String parseTemperature(String response) {
        // Parse the temperature from the JSON response
        JSONObject jsonResponse = new JSONObject(response);
        double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
        return temperature + "°C";
    }

    private static String parseHumidity(String response) {
        // Parse the humidity from the JSON response
        JSONObject jsonResponse = new JSONObject(response);
        int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
        return humidity + "%";
    }

    private static String parseWindSpeed(String response) {
        // Parse the wind speed from the JSON response
        JSONObject jsonResponse = new JSONObject(response);
        double windSpeed = jsonResponse.getJSONObject("wind").getDouble("speed");
        return windSpeed + " km/h";
    }
}
