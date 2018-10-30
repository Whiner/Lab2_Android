package com.university.lab2.products;

import java.util.List;

public class ShoesCalculator {
    public static int maxPrice(SportShoes sportShoes){
        List<SportShoesInfo> options = sportShoes.getOptions();
        int max = 0;
        for (SportShoesInfo option : options) {
            if (option.getPrice() > max) {
                max = option.getPrice();
            }
        }
        return max;
    }

    public static int minPrice(SportShoes sportShoes){
        List<SportShoesInfo> options = sportShoes.getOptions();
        int min = 9999999;
        for (SportShoesInfo option : options) {
            if (option.getPrice() < min) {
                min = option.getPrice();
            }
        }
        return min;
    }
}
