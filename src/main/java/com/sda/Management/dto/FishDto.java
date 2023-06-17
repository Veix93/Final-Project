package com.sda.Management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FishDto {
    private Long fishId;
    private String fishName;
    private Float fishWeight;
    private String fishImageUrl;
    private BaitDto baitDto;
    private LocationDto locationDto;
    private WeatherDto weatherDto;

    public FishDto(Long fishId, String fishName, Float fishWeight) {
        this.fishId = fishId;
        this.fishName = fishName;
        this.fishWeight = fishWeight;
    }
}

