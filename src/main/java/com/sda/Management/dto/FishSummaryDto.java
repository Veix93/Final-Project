package com.sda.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FishSummaryDto {
    private FishDto biggestCaughtFish;
    private Integer totalFishAmount;


}
