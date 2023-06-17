package com.sda.Management.dto;

import com.sda.Management.models.fishingDetails.WaterBody;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LocationDto {
    private Long locationId;
    private String country;
    private String town;
    private WaterBody waterBody;
    private String waterBodyName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fishingDate;
}
