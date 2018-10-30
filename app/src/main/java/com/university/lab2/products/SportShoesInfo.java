package com.university.lab2.products;

import android.graphics.drawable.Drawable;

import lombok.Data;

@Data
public class SportShoesInfo {
    private String color;
    private Integer price;
    private Drawable image;

    public SportShoesInfo() {
    }

    public SportShoesInfo(String color, Integer price, Drawable image) {
        this.color = color;
        this.price = price;
        this.image = image;
    }


}
