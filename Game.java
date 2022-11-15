package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB countryDB;
    private String answer;

    public Game() {
        this.countryDB = new CountryDB();
    }

    public String QA() {
        Map<String, Country> data = countryDB.getData();
        List<String> capitals = countryDB.getCapitals();
        int listSize = capitals.size();
        int index = (int) (listSize * Math.random());
        String c = capitals.get(index);
        Country ref = data.get(c);
        if (Math.random() < 0.5) {
            this.answer = ref.getCapital();
            return String.format("What is the capital of %s?%n%s", ref.getName(), ref.getCapital());
        } else {
            this.answer = ref.getName();
            return String.format("%s is the capital of?%n%s", ref.getCapital(), ref.getName());
        }
    }

    public String getAnswer() {
        return this.answer;
    }
}
