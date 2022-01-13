package com.dbeaver.weather.repositories;

import com.dbeaver.weather.models.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherHistory, Long> {
    Optional<WeatherHistory> findByWeatherDate(LocalDate date);
}
