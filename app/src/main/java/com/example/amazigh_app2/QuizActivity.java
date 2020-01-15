package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private MediaPlayer player;

    private GridView gridView;
    private Integer count;
    private String categorie;
    private ArrayList<Integer> images = new ArrayList<Integer>(6);
    private int[] images_keys = new int[6];
    private String imageName;
    private int sound;
    private Integer pogingen = 3;
    private Random r = new Random();
    static int score = 0;
    Handler handler = new Handler();
    final static int DELAY = 1000;

    int[] dummie_images = {
            R.drawable.dieren01_ezel,
            R.drawable.dieren01_paard,
            R.drawable.dieren01_schaap,
            R.drawable.dieren01_geit,
            R.drawable.dieren01_kip,
            R.drawable.dieren01_konijn,
            R.drawable.dieren01_koe,
            R.drawable.dieren01_hond,
            R.drawable.dieren01_vogel,
            R.drawable.dieren01_kat,
            R.drawable.dieren01_muis,
            R.drawable.dieren01_egel,
            R.drawable.dieren01_vis,
            R.drawable.dieren01_kikker,
            R.drawable.dieren01_jakhals,
    };

    int[] dummie_sounds = {
            R.raw.dieren01_ezel,
            R.raw.dieren01_paard,
            R.raw.dieren01_schaap,
            R.raw.dieren01_geit,
            R.raw.dieren01_kip,
            R.raw.dieren01_konijn,
            R.raw.dieren01_koe,
            R.raw.dieren01_hond,
            R.raw.dieren01_vogel,
            R.raw.dieren01_kat,
            R.raw.dieren01_muis,
            R.raw.dieren01_egel,
            R.raw.dieren01_kikker,
            R.raw.dieren01_jakhals,
    };

    String[] names = {
            "ezel",
            "paard",
            "schaap (ram)",
            "geit",
            "kip",
            "konijn",
            "koe",
            "hond",
            "vogel",
            "kat",
            "muis",
            "egel",
            "vis",
            "kikker",
            "jakhals",
    };

    String[] amazigh = {
            "aɣyul",
            "ayis",
            "icerri",
            "tɣaṭṭ",
            "tyaziḍt",
            "aqninni",
            "tafunast",
            "ayḍi",
            "agḍiḍ",
            "mucc",
            "aɣerda",
            "insi",
            "aslem",
            "aqaqriw",
            "uccen",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().hide();

        setCategorieNaam();

        setAmazighWord();

        setImages();
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter(this);
        gridView.setAdapter(customAdapter);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                play(sound);
            }
        }, DELAY);

        ImageButton button = findViewById(R.id.sound);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(sound);
            }
        });
    }

    public void setCategorieNaam() {
        Bundle bundle = getIntent().getExtras();
        categorie = bundle.getString("categorie");

        TextView categorieView = findViewById(R.id.categorieView);
        categorieView.setText(categorie);
        getSupportActionBar().setTitle(categorie);
    }

    public void setAmazighWord() {
        TextView AmazighWord = (TextView) findViewById(R.id.AmazighWord);
        Intent intent = getIntent();
        if (intent.hasExtra("count")) {
            Bundle bundle = getIntent().getExtras();
            count = bundle.getInt("count");
            if (count == 14) {
                intent = new Intent(this, UitslagActivity.class);
                intent.putExtra("score", score);
                intent.putExtra("aantal", dummie_images.length);
                startActivity(intent);
            } else {
                count++;
            }
        } else {
            count = 0;
        }
        AmazighWord.setText(amazigh[count]);
        sound = (dummie_sounds[count]);
    }

    public void setImages() {
        int i = 0;
        while (i < 6) {
            Integer randomIndex = r.nextInt(14);
            if (!images.contains(dummie_images[randomIndex])) {
                images.add(dummie_images[randomIndex]);
                images_keys[i] = randomIndex;
                i++;
            }
        }
        if (!images.contains(dummie_images[count])) {
            Integer randomIndex = r.nextInt(6);
            images.set(randomIndex, dummie_images[count]);
            images_keys[randomIndex] = count;
        }
        imageName = names[count];
    }

    class CustomAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater inflater;

        public CustomAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.image_quiz_layout, null);

            TextView nameTV = view.findViewById(R.id.name);
            ImageView image = view.findViewById(R.id.image);

            String name = names[images_keys[position]];
            nameTV.setText(name);
            image.setImageResource(images.get(position));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView nameView = view.findViewById(R.id.name);
                    String name = nameView.getText().toString();
                    if (name.equals(imageName)) {
                        geraden(view);
                    } else {
                        fout(view);
                    }

                }
            });
            return view;

        }
    }

    public void geraden(View view) {
        score = score + pogingen;

        if(pogingen != 0) {
            play(R.raw.success_sound_effect);
        }
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("count", count);
        intent.putExtra("categorie", categorie);
        startActivity(intent);

        Intent intentQuizWord = new Intent(this, QuizWordActivity.class);
        intentQuizWord.putExtra("amazigh", amazigh[count]);
        intentQuizWord.putExtra("vertaling", imageName);
        intentQuizWord.putExtra("image", dummie_images[count]);
        intentQuizWord.putExtra("pogingen", pogingen);
        startActivity(intentQuizWord);
    }

    public void fout(View view) {
        pogingen--;
        play(R.raw.failure_sound_effect);
        ImageView pogingenView = (ImageView) findViewById(R.id.pogingenImage);
        if (pogingen == 0) {
            pogingenView.setImageResource(R.drawable.helaas);
            geraden(view);
        }
        if (pogingen == 2) {
            pogingenView.setImageResource(R.drawable.pogingen2);
        }
        if (pogingen == 1) {
            pogingenView.setImageResource(R.drawable.poging1);
        }
    }

    public void play(int sound) {
        if (player == null) {
            player = MediaPlayer.create(this, sound);
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

