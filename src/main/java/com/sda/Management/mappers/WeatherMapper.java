package com.sda.Management.mappers;

import com.sda.Management.dto.WeatherDto;
import com.sda.Management.models.fishingDetails.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherDto weatherToDto(Weather weather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setWeatherId(weather.getWeatherId());
        weatherDto.setAirTemperature(weather.getAirTemperature());
        weatherDto.setSeason(weather.getSeason());
        weatherDto.setWeatherDescription(weather.getWeatherDescription());
        return weatherDto;
    }

    public Weather weatherToEntity(WeatherDto weatherDto) {
        Weather weather = new Weather();
        weather.setWeatherId(weatherDto.getWeatherId());
        weather.setAirTemperature(weatherDto.getAirTemperature());
        weather.setSeason(weatherDto.getSeason());
        weather.setWeatherDescription(weatherDto.getWeatherDescription());
        return weather;
    }
}
