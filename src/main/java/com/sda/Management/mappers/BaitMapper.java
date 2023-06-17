package com.sda.Management.mappers;

import com.sda.Management.dto.BaitDto;
import com.sda.Management.models.fishingDetails.Bait;
import org.springframework.stereotype.Component;

@Component
public class BaitMapper {

    public BaitDto baitToDto(Bait bait) {
        BaitDto baitDto = new BaitDto();
        baitDto.setBaitId(bait.getBaitId());
        baitDto.setBaitName(bait.getBaitName());
        baitDto.setBaitSize(bait.getBaitSize());
        baitDto.setBaitImageUrl(bait.getBaitImageUrl());
        return baitDto;
    }

    public Bait baitToEntity(BaitDto baitDto) {
        Bait bait = new Bait();
        bait.setBaitId(baitDto.getBaitId());
        bait.setBaitName(baitDto.getBaitName());
        bait.setBaitSize(baitDto.getBaitSize());
        bait.setBaitImageUrl(baitDto.getBaitImageUrl());
        return bait;
    }
}
