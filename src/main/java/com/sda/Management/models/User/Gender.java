package com.sda.Management.models.User;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String displayGender;

    Gender(String displayGender) {
        this.displayGender= displayGender;
    }

    public String getDisplayGender() {
        return displayGender;
    }
}
