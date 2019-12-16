package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

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
            R.drawable.dieren01_ezel,
            R.drawable.dieren01_geit,
            R.drawable.dieren01_hond,
            R.drawable.dieren01_jakhals,
            R.drawable.dieren01_kat,
            R.drawable.dieren01_kikker,
    };

    String[] names = {
            "Egel",
            "Ezel",
            "Geit",
            "Hond",
            "Jakhals",
            "Kat",
            "Kikker"
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

        CustomAdaptor customAdapter = new CustomAdaptor();
        listView.setAdapter(customAdapter);
    }

    class CustomAdaptor extends BaseAdapter {

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
        public View getView (int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.listviewlayout, null);
            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView = view.findViewById(R.id.textView);
            imageView.setImageResource(images[position]);
            textView.setText(names[position]);
            return view;
        }
    }
}
