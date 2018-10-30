package com.university.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.university.lab2.listeners.OnSwipeListener;
import com.university.lab2.products.Products;
import com.university.lab2.products.SportShoes;
import com.university.lab2.products.SportShoesInfo;

import java.util.List;

public class ColorActivity extends AppCompatActivity {

    private List<SportShoesInfo> options;
    private SportShoesInfo currentInfo;
    private String name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        intent = getIntent();
        String hash = intent.getStringExtra("hash");
        SportShoes byHashCode = Products.getInstance().getByHashCode(Integer.parseInt(hash));
        if (byHashCode != null) {
            options = byHashCode.getOptions();
            name = byHashCode.getName();
            currentInfo = options.get(0);
            fillActivity();
        } else {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.colorLayout).setOnTouchListener(new OnSwipeListener(this) {
            @Override
            public void onSwipeRight() {
                SportShoesInfo left = getLeft();
                if (left != null) {
                    currentInfo = left;
                    fillActivity();
                }
            }

            @Override
            public void onSwipeLeft() {
                SportShoesInfo right = getRight();
                if (right != null) {
                    currentInfo = right;
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
        findViewById(R.id.color_returnButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private SportShoesInfo getRight() {
        int i = options.indexOf(currentInfo);
        if (i != options.size() - 1) {
            return options.get(i + 1);
        }
        return null;
    }

    private SportShoesInfo getLeft() {
        int i = options.indexOf(currentInfo);
        if (i != 0) {
            return options.get(i - 1);
        }
        return null;
    }

    private void fillActivity() {
        ImageView imageView = findViewById(R.id.color_productImageView);
        imageView.setImageDrawable(currentInfo.getImage());

        TextView productPrice = findViewById(R.id.color_productPrice);

        String priceString = currentInfo.getPrice() + " рублей";
        productPrice.setText(priceString);

        TextView productTitle = findViewById(R.id.color_productTitle);
        productTitle.setText(name);

        TextView productColor = findViewById(R.id.color_productColor);
        productColor.setText(currentInfo.getColor());

        intent.putExtra("color", currentInfo.getColor());
        setResult(RESULT_OK, intent);
    }

}
