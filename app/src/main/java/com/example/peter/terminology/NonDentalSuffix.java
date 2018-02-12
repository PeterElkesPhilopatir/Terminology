package com.example.peter.terminology;

/**
 * Created by Peter on 23/10/2017.
 */

public class NonDentalSuffix {
    private String suffix;
    private String meaning;
    private String example;

    public NonDentalSuffix(String suffix, String meaning, String example) {
        this.suffix = suffix;
        this.meaning = meaning;
        this.example = example;
    }


    public String getSuffix() {
        return suffix;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getExample() {
        return example;
    }
}
