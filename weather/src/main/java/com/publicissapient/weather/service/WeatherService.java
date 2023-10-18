package com.publicissapient.weather.service;

import java.util.List;
import com.publicissapient.weather.model.WeatherForecast;

public interface WeatherService {

    List<WeatherForecast> getCityWeather(String city);

}
