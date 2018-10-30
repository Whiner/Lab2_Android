package com.university.lab2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.university.lab2.products.Products;
import com.university.lab2.products.SportShoes;
import com.university.lab2.products.SportShoesInfo;

public class InfoActivity extends AppCompatActivity {

    private SportShoes sportShoes;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        intent = getIntent();
        String hash = intent.getStringExtra("hash");
        sportShoes = Products.getInstance().getByHashCode(Integer.parseInt(hash));
        if(sportShoes != null){
            fillActivity();
        }
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                intent.putExtra("rating", v);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void fillActivity(){
        ImageView imageView = findViewById(R.id.sportShoes_imageView);
        imageView.setImageDrawable(sportShoes.getOptions().get(0).getImage());

        TextView name = findViewById(R.id.shooes_name_textview);
        String text = sportShoes.getName();
        name.setText(text);

        TextView info = findViewById(R.id.info_textview);
        String infoText = "Тип обуви: " + sportShoes.getType() + "\n" +
                "Подошва: " + sportShoes.getSoleType() + "\n" +
                "Доступные цвета: " + Products.getInstance().getColorList(sportShoes);
        info.setText(infoText);

    }
}
