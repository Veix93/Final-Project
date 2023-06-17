package com.sda.Management.mappers;

import com.sda.Management.dto.FishDto;
import com.sda.Management.dto.FishSummaryDto;
import com.sda.Management.models.fishingDetails.Fish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FishMapper {

    private final BaitMapper baitMapper;
    private final LocationMapper locationMapper;
    private final WeatherMapper weatherMapper;


    @Autowired
    public FishMapper(BaitMapper baitMapper,
                      LocationMapper locationMapper,
                      WeatherMapper weatherMapper) {
        this.baitMapper = baitMapper;
        this.locationMapper = locationMapper;
        this.weatherMapper = weatherMapper;

    }

    public FishDto fishToDto(Fish fish) {
        FishDto fishDto = new FishDto();
        fishDto.setFishId(fish.getFishId());
        fishDto.setFishName(fish.getFishName());
        fishDto.setFishWeight(fish.getFishWeight());
        fishDto.setFishImageUrl(fish.getFishImageUrl());
        fishDto.setBaitDto(baitMapper.baitToDto(fish.getBait()));
        fishDto.setLocationDto(locationMapper.locationToDto(fish.getLocation()));
        fishDto.setWeatherDto(weatherMapper.weatherToDto(fish.getWeather()));
        return fishDto;
    }

    public FishSummaryDto fishToSummaryDto (Fish fish, int totalFishAmount){
        FishDto fishDto = fishToDto(fish);
        return new FishSummaryDto(fishDto, totalFishAmount);

    }

    public Fish fishToEntity(FishDto fishDto) {
        Fish fish = new Fish();
        fish.setFishId(fishDto.getFishId());
        fish.setFishName(fishDto.getFishName());
        fish.setFishWeight(fishDto.getFishWeight());
        fish.setFishImageUrl(fishDto.getFishImageUrl());
        fish.setBait(baitMapper.baitToEntity(fishDto.getBaitDto()));
        fish.setLocation(locationMapper.locationToEntity(fishDto.getLocationDto()));
        fish.setWeather(weatherMapper.weatherToEntity(fishDto.getWeatherDto()));
        return fish;
    }
}
