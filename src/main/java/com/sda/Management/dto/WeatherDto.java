package com.sda.Management.dto;

import com.sda.Management.models.fishingDetails.Season;
import lombok.Data;

@Data
public class WeatherDto {
    private Long weatherId;
    private Double airTemperature;
    private Season season;
    private String weatherDescription;
}
