package com.sda.Management.models.fishingDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long locationId;
    private String country;
    private String town;
    @Column(name = "water_bodies")
    @Enumerated(EnumType.STRING)
    private WaterBody waterBody;
    @Column(name = "waterbody_name")
    private String waterBodyName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fishingDate;
    @OneToOne(mappedBy = "location")
    private Fish fish;

}
