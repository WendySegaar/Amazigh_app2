package com.example.amazigh_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
//database
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OverOnsActivity extends AppCompatActivity {

    SQLiteHelper projectDB;
    EditText editText_Categorie, editText_Afbeelding, editText_Sound;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_ons);
        getSupportActionBar().setTitle("Over ons");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#FFEA2B")));

        editText_Categorie = (EditText)findViewById(R.id.editText_Categorie);
        editText_Afbeelding = (EditText)findViewById(R.id.editText_Afbeelding);
        editText_Sound = (EditText)findViewById(R.id.editText_Sound);
        btnAddData = (Button)findViewById(R.id.button_addData);
        //database
        projectDB = new SQLiteHelper(this);
        AddData();
//        Cursor resultSet = ProjectDatabase.rawQuery("Select * from TutorialsPoint",null);
//        resultSet.ProjectDatabase();
//        String username = resultSet.getString(0);
//        String password = resultSet.getString(1);
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = projectDB.insertDate(editText_Categorie.getText().toString(),
                                editText_Afbeelding.getText().toString(),
                                editText_Sound.getText().toString() );
                        if (isInserted =true)
                            Toast.makeText(OverOnsActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(OverOnsActivity.this, "Data is not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
