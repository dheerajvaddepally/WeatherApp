package com.dheeraj.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dheeraj on 16/12/17.
 */

public class WeatherResponse {
    private List<Weather> weather = null;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "weather=" + weather +
                '}';
    }
}
