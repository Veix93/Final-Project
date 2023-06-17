package com.sda.Management.services;

import com.sda.Management.dto.FishDto;
import com.sda.Management.dto.FishSummaryDto;
import com.sda.Management.models.fishingDetails.Fish;

import java.util.List;

public interface FishService {

    FishDto createFish(FishDto fishDto);

    List<FishDto> getAllFishes();

    FishDto getFishById(Long fishId);

    FishDto updateFish(FishDto fishDto, Long fishId);

    void deleteFishById(Long id);

    FishSummaryDto getFishSummary();

}