package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ScoresActivity extends AppCompatActivity {

    ListView listView;

    String[] categories = {
            "Dieren",
            "Dieren",
            "Weer",
            "Weer",
            "Weer",
            "Fruit",
            "Fruit",
            "Groente",
            "Groente",
            "Groente"
    };

    String[] datums = {
            "16-12-2019",
            "16-12-2019",
            "15-12-2019",
            "15-12-2019",
            "15-12-2019",
            "14-12-2019",
            "14-12-2019",
            "12-12-2019",
            "12-12-2019",
            "12-12-2019",
    };

    int[] ratings = {
           3,
           1,
           3,
           4,
           1,
           3,
           5,
           3,
           2,
           3,
           3,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        getSupportActionBar().setTitle("Scores");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#D90D0D")));

        listView = (ListView) findViewById(R.id.scores);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return categories.length;
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
            View view = getLayoutInflater().inflate(R.layout.scores_listview, null);
            TextView catTextView = view.findViewById(R.id.categorieText);
            TextView datumTextView = view.findViewById(R.id.datumText);
            RatingBar ratingBar = view.findViewById(R.id.myRatingBar);
            catTextView.setText(categories[position]);
            datumTextView.setText(datums[position]);
            ratingBar.setRating(ratings[position]);
            return view;
        }
    }
}
