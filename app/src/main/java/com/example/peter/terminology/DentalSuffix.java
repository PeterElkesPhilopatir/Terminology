package com.example.peter.terminology;

/**
 * Created by Peter on 23/10/2017.
 */

public class DentalSuffix {

    private String suffix;
    private String word;
    private String meaning;

    public DentalSuffix(String suffix, String word, String meaning) {
        this.suffix = suffix;
        this.word = word;
        this.meaning = meaning;    }

    public String getSuffix() {
        return suffix;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }
}
