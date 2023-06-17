package com.sda.Management.Fish;

import com.sda.Management.models.fishingDetails.Bait;
import com.sda.Management.models.fishingDetails.Fish;
import com.sda.Management.repository.FishRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FishBaitMappingTest {

    @Autowired
    private  FishRepository fishRepository;

    @Test
    void saveFish(){
        Fish fish = new Fish();

        fish.setFishName("Pike");
        fish.setFishWeight(2.5F);
        fish.setFishImageUrl("google.com");

        Bait bait = new Bait();
        bait.setBaitName("worm");
        bait.setBaitSize("small");
        bait.setBaitImageUrl("pooolo.ee");

        fish.setBait(bait);

        fishRepository.save(fish);
    }
}
