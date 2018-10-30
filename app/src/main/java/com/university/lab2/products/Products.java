package com.university.lab2.products;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.university.lab2.R;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final Products ourInstance = new Products();

    public static Products getInstance() {
        return ourInstance;
    }

    private Products() {
    }

    private double uanCourse = 2.4;
    private List<SportShoes> products = new ArrayList<>();

    public void fillProducts(Context context) {
        SportShoes e = new SportShoes();
        e.setProducer("Nike");
        e.setModel("Tanjuin");
        e.setSoleType("Пена");
        e.setType("Кроссовки для повседневной жизни");
        e.addOption(
                "Черный",
                (int) (2599 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.nike_tanjuin_black));
        e.addOption(
                "Синий",
                (int) (1799 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.nike_tanjuin_blue));
        products.add(e);

        e = new SportShoes();
        e.setProducer("Puma");
        e.setModel("Comet");
        e.setSoleType("Резина");
        e.setType("Кроссовки для бега");
        e.addOption(
                "Черный",
                (int) (1199 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.puma_comet__black));
        e.addOption(
                "Синий",
                (int) (1999 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.puma_comet__blue));
        e.addOption(
                "Красный",
                (int) (1999 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.puma_comet__red));
        products.add(e);

        e = new SportShoes();
        e.setProducer("Skechers");
        e.setModel("KM3056");
        e.setSoleType("Резина");
        e.setType("Кроссовки для повседневной жизни");
        e.addOption(
                "Черный",
                (int) (2200 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_black));
        e.addOption(
                "Синий",
                (int) (2200 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_blue));
        products.add(e);

        e = new SportShoes();
        e.setProducer("Skechers");
        e.setModel("GO");
        e.setSoleType("Резина");
        e.setType("Кроссовки для бега");
        e.addOption(
                "Черный",
                (int) (1999 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_go_black));
        e.addOption(
                "Синий",
                (int) (1000 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_go_blue));
        e.addOption(
                "Красный",
                (int) (799 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_go_red));
        e.addOption(
                "Серый",
                (int) (1000 * uanCourse),
                ContextCompat.getDrawable(context, R.drawable.skechers_go_grey));
        products.add(e);
    }

    public List<SportShoes> getProducts() {
        return products;
    }


    public SportShoes getByHashCode(int hashCode) {
        for (SportShoes sportShoes : products) {
            if (sportShoes.hashCode() == hashCode) {
                return sportShoes;
            }
        }
        return null;
    }

    public String getColorList(SportShoes sportShoes){
        String colors = "";
        int size = sportShoes.getOptions().size();
        for (int i = 0; i < size; i++) {
            colors = colors.concat(sportShoes.getOptions().get(i).getColor());
            if(i < size - 1){
                colors = colors.concat(",");
            }
        }
        return colors;
    }
}
