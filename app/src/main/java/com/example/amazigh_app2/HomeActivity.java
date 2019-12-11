package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button button_quiz;
    private Button button_oefenen;
    private Button button_over_ons;
    private Button button_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button_quiz = (Button) findViewById(R.id.button_quiz);
        button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategories(true);
            }
        });

        button_oefenen = (Button) findViewById(R.id.button_oefenen);
        button_oefenen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCategories(false);
            }
        });

        button_scores = (Button) findViewById(R.id.button_scores);
        button_scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openScores();
            }
        });

        button_over_ons = (Button) findViewById(R.id.button_over_ons);
        button_over_ons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOverOns();
            }
        });
    }

    public void openCategories(Boolean bool) {
        Intent intent = new Intent(this, CategorieActivity.class);
        intent.putExtra("redirect", bool);
        startActivity(intent);
    }

    public void openScores() {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    public void openOverOns() {
        Intent intent = new Intent(this, OverOnsActivity.class);
        startActivity(intent);
    }

}
