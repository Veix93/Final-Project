package com.sda.Management.models.fishingDetails;

public enum WaterBody {
    LAKE("Lake"),
    RIVER("River"),
    SEA("Sea"),
    POND("Pond"),
    STREAM("Stream"),
    OCEAN("Ocean"),
    CANAL("Canal"),
    RESERVOIR("Reservoir");

    private final String displayWaterBody;

    WaterBody(String displayWaterBody) {
        this.displayWaterBody = displayWaterBody;
    }
    public String getDisplayWaterBody() {
        return displayWaterBody;
    }
}
