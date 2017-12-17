package com.dheeraj.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dheeraj on 16/12/17.
 */

class Weather {
    private String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                '}';
    }
}
