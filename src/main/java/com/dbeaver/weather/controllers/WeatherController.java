package com.dbeaver.weather.controllers;

import com.dbeaver.weather.models.WeatherHistory;
import com.dbeaver.weather.repositories.WeatherRepository;
import com.dbeaver.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class WeatherController {
    private final WeatherRepository repository;
    private final WeatherService service;

    @Autowired
    public WeatherController(WeatherRepository repository, WeatherService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/weather")
    @ResponseBody
    public String getWeather() {
        LocalDate date = LocalDate.now();

        //Ищем сегодняшнюю погоду в базе
        Optional<WeatherHistory> weather = repository.findByWeatherDate(date);

        //Если сегодняшнаяя погода найдена - возвращаем ее, если нет - получаем ее через сервис, записываем в базу и возвращаем
        if(weather.isPresent())
            return weather.get().getWeatherValue();
        else {
            String stringWeather = service.getWeatherFromYa();

            repository.save(new WeatherHistory(date, stringWeather));

            return stringWeather;
        }
    }
}
