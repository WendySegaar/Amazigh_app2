package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private GridView gridView;
    private Integer count;
    private String categorie;
    private ArrayList<Integer> images = new ArrayList<Integer>(6);
    private int[] images_keys = new int[6];
    private String imageName;
    private Integer pogingen = 3;
    private Random r = new Random();

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
        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#5ace20")));
        setCategorieNaam();

        setAmazighWord();

        setImages();
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter(this);
        gridView.setAdapter(customAdapter);
    }

    public void setCategorieNaam() {
        Bundle bundle = getIntent().getExtras();
        categorie = bundle.getString("categorie");

        TextView categorieTV = (TextView) findViewById(R.id.categorieNaam);
        categorieTV.setText(categorie);
    }

    public void setAmazighWord() {
        TextView AmazighWord = (TextView) findViewById(R.id.AmazighWord);
        Intent intent = getIntent();
        if (intent.hasExtra("count")) {
            Bundle bundle = getIntent().getExtras();
            count = bundle.getInt("count");
            if (count == 14) {
                intent = new Intent(this, UitslagActivity.class);
                startActivity(intent);
            } else {
                count++;
            }
        } else {
            count = 0;
        }
        AmazighWord.setText(amazigh[count]);
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
                    if (name.equals(imageName) ) {
                        geraden(view);
                    }

                }
            });
            return view;

        }
    }

    public void geraden(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("count", count);
        intent.putExtra("categorie", categorie);
        startActivity(intent);
    }

//    public void fout() {
//        pogingen--;
//        if (pogingen == 0){
//            //zet limiet
//        } else {
//
//        }
//    }
}

