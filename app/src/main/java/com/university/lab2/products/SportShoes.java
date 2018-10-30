package com.university.lab2.products;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class SportShoes {
    private String producer;
    private String model;
    private String type;
    private String soleType;
    private List<SportShoesInfo> options = new ArrayList<>();

    public void addOption(@NonNull String color, @NonNull Integer price, Drawable image) {
        options.add(new SportShoesInfo(color, price, image));
    }

    public String getName() {
        return producer + " " + model;
    }

    public SportShoes() {
    }

}
