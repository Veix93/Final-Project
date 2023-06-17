package com.sda.Management.models.fishingDetails;

public enum Season {
    SUMMER("Summer"),
    SPRING("Spring"),
    WINTER("Winter"),
    AUTUMN("Autumn");

    private final String displaySeason;

    Season(String displaySeason) {
        this.displaySeason = displaySeason;
    }

    public String getDisplaySeason() {
        return displaySeason;
    }
}
