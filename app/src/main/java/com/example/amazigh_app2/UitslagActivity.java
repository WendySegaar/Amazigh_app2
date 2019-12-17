package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class UitslagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitslag);
        getSupportActionBar().setTitle("Uitslag");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#FD6A02")));

        setUitslag();
    }

    public void setUitslag() {
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");
        int aantal = bundle.getInt("aantal");

        Double scoreD = Double.valueOf(score);
        Double aantalD = Double.valueOf(aantal);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.myRatingBar);
        TextView textView = (TextView) findViewById(R.id.Uitslag);

        double calc = Math.round(score* 100 / (aantal * 3));

        if (0 < calc && calc <= 20) {
            ratingBar.setRating(1);
            textView.setText("Nog even wat meer oefenen...");
        } else if (20 < calc && calc <= 40) {
            ratingBar.setRating(2);
            textView.setText("Volgende keer beter.");
        } else if (40 < calc && calc <= 60) {
            ratingBar.setRating(3);
            textView.setText("Je bent goed op weg.");
        } else if (60 < calc && calc <= 80) {
            ratingBar.setRating(4);
            textView.setText("Goed gedaan!");
        } else if (80 < calc && calc <= 100) {
            ratingBar.setRating(5);
            textView.setText("Wauw! Fantastisch!");
        } else {
            ratingBar.setRating(0);
            textView.setText("Nog even wat meer oefenen...");
        }
    }
}
