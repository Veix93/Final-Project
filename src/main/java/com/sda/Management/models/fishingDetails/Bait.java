package com.sda.Management.models.fishingDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "baits")
public class Bait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long baitId;
    private String baitName;
    private String baitSize;
    private String BaitImageUrl;
    @OneToOne(mappedBy = "bait")
    private Fish fish;

}
