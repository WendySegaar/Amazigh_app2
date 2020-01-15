package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.amazigh_app2.R;

public class OefenenActivity extends AppCompatActivity {
    private MediaPlayer player;
    TextView message;
    TextView message2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oefenen);
        getSupportActionBar().setTitle("Dieren");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#326BB6")));

        ImageButton buttonsound = findViewById(R.id.sound);

        buttonsound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                play();
            }
        });

        final ViewPager viewPager = (ViewPager)
                findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new
                                                  ViewPager.OnPageChangeListener() {

                                                      public void onPageScrollStateChanged(int state) {
                                                      }

                                                      public void onPageScrolled(int position, float positionOffset,
                                                                                 int positionOffsetPixels) {
                                                      }


                                                      /*This needs fixing with database*/
                                                      public void onPageSelected(int position) {
                                                          String s = getResources().getResourceEntryName(R.drawable.dieren01_paard);
                                                          setTitle(s);
// Take dutch word from database
                                                          message = (TextView) findViewById(R.id.NLwoord);
                                                          message.setText(s);
// Take amazigh word from database
                                                          message2 = (TextView) findViewById(R.id.ENGwoord);
                                                          message2.setText(s);

                                                          play();
                                                      }
                                                  });
    }


    public void play() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.test);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
            player.start();
        }
    }

    public void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

}
