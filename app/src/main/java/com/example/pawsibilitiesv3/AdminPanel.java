package com.example.pawsibilitiesv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPanel extends AppCompatActivity {

    Button btnAddv,btnCur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        btnAddv = (Button)findViewById(R.id.btnAddv);
        btnAddv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPanel.this, AddActivity.class));
            }
        });

        btnCur = (Button)findViewById(R.id.btnCur);
        btnCur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminPanel.this, MainActivity.class));
            }
        });
    }
}