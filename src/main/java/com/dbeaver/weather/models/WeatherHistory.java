package com.dbeaver.weather.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class WeatherHistory {
    @Id
    private LocalDate weatherDate;
    private String weatherValue;

    public WeatherHistory() {
    }

    public WeatherHistory(LocalDate date, String value) {
        this.weatherDate = date;
        this.weatherValue = value;
    }

    public LocalDate getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(LocalDate date) {
        this.weatherDate = date;
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String value) {
        this.weatherValue = value;
    }
}
