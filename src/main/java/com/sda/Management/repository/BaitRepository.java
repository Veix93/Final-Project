package com.sda.Management.repository;

import com.sda.Management.models.fishingDetails.Bait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaitRepository extends JpaRepository<Bait, Long> {

}
