package com.university.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.university.lab2.listeners.OnSwipeListener;
import com.university.lab2.products.Products;
import com.university.lab2.products.ShoesCalculator;
import com.university.lab2.products.SportShoes;
import com.university.lab2.products.SportShoesInfo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SportShoes currentShoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Products.getInstance().fillProducts(this);
        products = Products.getInstance().getProducts();
        currentShoes = products.get(0);
        fillActivity();
        findViewById(R.id.mainLayout).setOnTouchListener(new OnSwipeListener(this) {
            @Override
            public void onSwipeRight() {
                SportShoes left = getLeft();
                if (left != null) {
                    currentShoes = left;
                    fillActivity();
                }
            }

            @Override
            public void onSwipeLeft() {
                SportShoes right = getRight();
                if (right != null) {
                    currentShoes = right;
                    fillActivity();
                }
            }

            @Override
            public void onSwipeTop() {

            }

            @Override
            public void onSwipeBottom() {

            }
        });
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        Button colorButton = findViewById(R.id.colorButton);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ColorActivity.class);
            intent.putExtra("hash", "" + currentShoes.hashCode());
            startActivityForResult(intent, 1);

            }
        });
        Button infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.university.lab2.SHOWINFO");
                intent.putExtra("hash", "" + currentShoes.hashCode());
                startActivityForResult(intent,2);
            }
        });
    }

    private List<SportShoes> products;

    private SportShoes getRight() {
        int i = products.indexOf(currentShoes);
        if (i != products.size() - 1) {
            return products.get(i + 1);
        }
        return null;
    }

    private SportShoes getLeft() {
        int i = products.indexOf(currentShoes);
        if (i != 0) {
            return products.get(i - 1);
        }
        return null;
    }

    private void fillActivity() {
        ImageView imageView = findViewById(R.id.productImageView);
        SportShoesInfo first = currentShoes.getOptions().get(0);
        imageView.setImageDrawable(first.getImage());

        int minPrice = ShoesCalculator.minPrice(currentShoes);
        int maxPrice = ShoesCalculator.maxPrice(currentShoes);

        TextView productPrice = findViewById(R.id.productPrice);
        if (minPrice == maxPrice) {
            String text = minPrice + " рублей";
            productPrice.setText(text);
        } else {
            String priceString = minPrice + " - " + maxPrice + " рублей";
            productPrice.setText(priceString);
        }

        TextView productTitle = findViewById(R.id.productTitle);
        productTitle.setText(currentShoes.getName());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1) {
            if (data != null) {
                Toast.makeText(this, "Отличный цвет - " + data.getStringExtra("color"), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Давайте посмотрим другие варианты", Toast.LENGTH_SHORT).show();

            }
        } else {
            if (data != null) {
                float rating = data.getFloatExtra("rating", 0);
                if(rating < 4){
                    Toast.makeText(this, "Че так мало то?", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Рады, что Вам понравилось", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
