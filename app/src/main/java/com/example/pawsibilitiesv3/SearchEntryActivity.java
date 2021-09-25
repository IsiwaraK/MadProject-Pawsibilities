package com.example.pawsibilitiesv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchEntryActivity extends AppCompatActivity {

    Button btnSearch,btnVetEntry,btnDay,btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_entry);


        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchEntryActivity.this, SearchActivity.class));
            }
        });

        btnVetEntry = (Button)findViewById(R.id.btnVetEntry);
        btnVetEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchEntryActivity.this, AdminPanel.class));
            }
        });

        btnDay = (Button)findViewById(R.id.btnDay);
        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchEntryActivity.this, VetDurationActivity.class));
            }
        });

        btnExit = (Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}