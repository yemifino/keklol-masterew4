package com.example.sasha.smarthcs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class has_light {
    @SerializedName("cosstl")
    private List<String> light;


    public List<String> getLight() {
        return light;
    }

    public void setLight(List<String> light) {
        this.light = light;
    }
}
