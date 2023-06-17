package com.sda.Management.mappers;

import com.sda.Management.dto.LocationDto;
import com.sda.Management.models.fishingDetails.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public LocationDto locationToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationId(location.getLocationId());
        locationDto.setCountry(location.getCountry());
        locationDto.setTown(location.getTown());
        locationDto.setWaterBody(location.getWaterBody());
        locationDto.setWaterBodyName(location.getWaterBodyName());
        locationDto.setFishingDate(location.getFishingDate());
        return locationDto;
    }

    public Location locationToEntity(LocationDto locationDto) {
        Location location = new Location();
        location.setLocationId(locationDto.getLocationId());
        location.setCountry(locationDto.getCountry());
        location.setTown(locationDto.getTown());
        location.setWaterBody(locationDto.getWaterBody());
        location.setWaterBodyName(locationDto.getWaterBodyName());
        location.setFishingDate(locationDto.getFishingDate());
        return location;
    }
}
