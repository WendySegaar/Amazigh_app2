package com.example.amazigh_app2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class QuizWordActivity extends AppCompatActivity {

    Handler handler = new Handler();
    final static int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_word);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        if (intent.hasExtra("pogingen")) {
            Bundle bundle = getIntent().getExtras();

            TextView amazighWord = findViewById(R.id.amazighWord);
            TextView vertalingView = findViewById(R.id.vertaling);
            ImageView imageView = findViewById(R.id.rightImage);

            int image = bundle.getInt("image");
            int pogingen = bundle.getInt("pogingen");
            String amazigh = bundle.getString("amazigh");
            String vertaling = bundle.getString("vertaling");

            amazighWord.setText(amazigh);
            vertalingView.setText(vertaling);
            imageView.setImageResource(image);
            TextView message = findViewById(R.id.message);
            ConstraintLayout quizWord = findViewById(R.id.quizWord);

            if (pogingen == 0) {
                quizWord.setBackground(
                        new ColorDrawable(Color.parseColor("#D90D0D")));
                message.setText("Helaas");

            } else {
                quizWord.setBackground(
                        new ColorDrawable(Color.parseColor("#5ace20")));
                message.setText("Goed gedaan");
            }
        }


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, DELAY);
    }
}
