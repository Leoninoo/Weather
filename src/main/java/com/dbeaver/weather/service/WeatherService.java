package com.dbeaver.weather.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService {
    private static final String URL = "https://yandex.ru/";

    public String getWeatherFromYa() {
        StringBuilder response = new StringBuilder();

        try {
            //Отправляем GET запрос на yandex
            URL obj = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            //Ищем в полученном ответе элемент с текущей погодой и получаем градусы
            while ((inputLine = in.readLine()) != null) {
                int i = inputLine.indexOf("weather__temp");

                if(i > 0) {
                    i += 15;
                    char ch;

                    while ((ch = inputLine.charAt(i)) != '<') {
                        response.append(ch);
                        i++;
                    }
                }
            }
            in.close();
        }
        catch (IOException ignored) { }

        return response.toString();
    }
}
