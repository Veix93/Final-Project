package com.sda.Management.services.impl;

//import com.sda.Management.config.SecurityUtil;
import com.sda.Management.dto.*;
import com.sda.Management.exceptions.FishNotFoundException;
import com.sda.Management.mappers.*;
import com.sda.Management.models.fishingDetails.Bait;
import com.sda.Management.models.fishingDetails.Fish;
import com.sda.Management.models.fishingDetails.Location;
import com.sda.Management.models.fishingDetails.Weather;
import com.sda.Management.repository.*;
import com.sda.Management.services.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishServiceImpl implements FishService {

    private  FishRepository fishRepository;
    private  BaitRepository baitRepository;
    private  LocationRepository locationRepository;
    private  WeatherRepository weatherRepository;
    private  FishMapper fishMapper;
    private  BaitMapper baitMapper;
    private  LocationMapper locationMapper;
    private  WeatherMapper weatherMapper;

    @Autowired
    public FishServiceImpl(FishRepository fishRepository,
                           BaitRepository baitRepository,
                           LocationRepository locationRepository,
                           WeatherRepository weatherRepository,
                           FishMapper fishMapper,
                           BaitMapper baitMapper,
                           LocationMapper locationMapper,
                            WeatherMapper weatherMapper
                           ) {
        this.fishRepository = fishRepository;
        this.baitRepository = baitRepository;
        this.locationRepository = locationRepository;
        this.weatherRepository = weatherRepository;
        this.fishMapper = fishMapper;
        this.baitMapper = baitMapper;
        this.locationMapper = locationMapper;
        this.weatherMapper = weatherMapper;
    }


    @Override
    public FishDto createFish(FishDto fishDto) {

        WeatherDto weatherDto = fishDto.getWeatherDto();
        Weather weather = weatherMapper.weatherToEntity(weatherDto);
        weather = weatherRepository.save(weather);

        LocationDto locationDto = fishDto.getLocationDto();
        Location location = locationMapper.locationToEntity(locationDto);
        location = locationRepository.save(location);

        BaitDto baitDto = fishDto.getBaitDto();
        Bait bait = baitMapper.baitToEntity(baitDto);
        bait = baitRepository.save(bait);


        Fish fish = fishMapper.fishToEntity(fishDto);
        fish.setBait(bait);
        fish.setLocation(location);
        fish.setWeather(weather);

        Fish newFish = fishRepository.save(fish);

        return fishMapper.fishToDto(newFish);
    }

    @Override
    public List<FishDto> getAllFishes() {
        List<Fish> listOfFishes = fishRepository.findAll();
        return listOfFishes.stream().map(p -> fishMapper.fishToDto(p)).collect(Collectors.toList());
    }

    @Override
    public FishDto getFishById(Long fishId) {
        Fish fish = fishRepository
                .findById(fishId)
                .orElseThrow(() -> new FishNotFoundException("Fish could not be found."));

        return fishMapper.fishToDto(fish);
    }

    @Override
    public FishDto updateFish(FishDto fishDto, Long id) {

        Fish fish = fishRepository
                .findById(id)
                .orElseThrow(() -> new FishNotFoundException("Fish could not be found."));

        fish.setFishName(fishDto.getFishName());
        fish.setFishWeight(fishDto.getFishWeight());
        fish.setFishImageUrl(fishDto.getFishImageUrl());

        Weather weather = weatherMapper.weatherToEntity(fishDto.getWeatherDto());
        weather = weatherRepository.save(weather);
        fish.setWeather(weather);

        Location location = locationMapper.locationToEntity(fishDto.getLocationDto());
        location = locationRepository.save(location);
        fish.setLocation(location);

        Bait bait = baitMapper.baitToEntity(fishDto.getBaitDto());
        bait = baitRepository.save(bait);
        fish.setBait(bait);

        Fish updatedFish = fishRepository.save(fish);
        return fishMapper.fishToDto(updatedFish);
    }

    @Override
    public void deleteFishById(Long id) {
        Fish fish = fishRepository
                .findById(id)
                .orElseThrow(() -> new FishNotFoundException("Fish could not be deleted."));
        fishRepository.delete(fish);
    }

    @Override
    public FishSummaryDto getFishSummary() {
        List<Fish> biggestCaughtFishList = fishRepository.findBiggestCaughtFish();
        int totalFishAmount = fishRepository.getTotalFishAmount();

        if (biggestCaughtFishList.isEmpty()) {
            throw new FishNotFoundException("No fish entities found.");
        }

        Fish biggestCaughtFish = biggestCaughtFishList.get(0);
        return fishMapper.fishToSummaryDto(biggestCaughtFish, totalFishAmount);
    }
}
