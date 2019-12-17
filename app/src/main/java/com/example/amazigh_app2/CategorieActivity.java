package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CategorieActivity extends AppCompatActivity {

    ListView listView;

    int[] images = {
            R.drawable.dieren01_egel,
            R.drawable.fruit_sinaasappel,
            R.drawable.insecten_mier,
            R.drawable.groente_doperwten,
            R.drawable.dieren02_vos,
            R.drawable.eten_koekjes,
            R.drawable.kleding_broek,
            R.drawable.weer_lente,
            R.drawable.kleuren_geel,

    };

    String[] names = {
            "Dieren 1",
            "Fruit",
            "Insecten",
            "Groente",
            "Dieren 2",
            "Eten",
            "Kleding",
            "Weer",
            "Kleuren",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        getSupportActionBar().setTitle("Categorieën");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#990099")));

        listView = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    public void redirect(String categorie) {
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("pagina").equals("quiz")) {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("categorie", categorie);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, OefenenActivity.class);
            intent.putExtra("categorie", categorie);
            startActivity(intent);
        }
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
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
        public View getView (final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listviewlayout, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    redirect(names[position]);
                }
            });
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            textView.setText(names[position]);
            return view;
        }
    }
}
