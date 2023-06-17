package com.sda.Management.models.fishingDetails;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "caught_fishes")
public class Fish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long fishId;
    @Column(name = "fish_name")
    private String fishName;
    @Column(name = "fish_weight")
    private Float fishWeight;
    private String fishImageUrl;
    @JoinColumn(name="bait_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Bait bait;
    @JoinColumn(name="location_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @JoinColumn(name="weather_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Weather weather;
}


