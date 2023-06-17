package com.sda.Management.repository;
import com.sda.Management.dto.FishDto;
import com.sda.Management.models.fishingDetails.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long>{

    @Query("SELECT f FROM Fish f WHERE f.fishWeight = (SELECT MAX(f2.fishWeight) FROM Fish f2)")
    List<Fish> findBiggestCaughtFish();

    @Query("SELECT COUNT(f) FROM Fish f")
    int getTotalFishAmount();


}
