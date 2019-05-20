package com.example.sasha.smarthcs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class has_water {
    @SerializedName("cosstw")
    private List<String> water;


    public List<String> getWater() {
        return water;
    }

    public void setWater(List<String> water) {
        this.water = water;
    }
}
