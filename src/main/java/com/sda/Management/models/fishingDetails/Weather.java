package com.sda.Management.models.fishingDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long weatherId;
    private Double airTemperature;
    @Enumerated(EnumType.STRING)
    private Season season;
    private String weatherDescription;
    @OneToOne(mappedBy = "weather")
    private Fish fish;

}
