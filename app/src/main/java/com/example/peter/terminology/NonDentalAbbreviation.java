package com.example.peter.terminology;

/**
 * Created by Peter on 23/10/2017.
 */

public class NonDentalAbbreviation {
    private String name;
    private String extension;

    public NonDentalAbbreviation(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }
}
