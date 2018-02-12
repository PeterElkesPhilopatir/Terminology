package com.example.peter.terminology;

/**
 * Created by Peter on 23/10/2017.
 */

public class DentalAbbreviation {

    private String name;
    private String meaning;

    public DentalAbbreviation(String name, String meaning) {
        this.name = name;
        this.meaning = meaning;
    }

    public String getName() {
        return name;
    }

    public String getMeaning() {
        return meaning;
    }
}
