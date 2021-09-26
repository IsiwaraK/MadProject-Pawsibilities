package com.madexample.pawssibilities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class shop extends AppCompatActivity implements View.OnClickListener {

    public CardView card1,card2,card3,card4,card5,card6,card7,card8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);
        card5 = (CardView) findViewById(R.id.c5);
        card6 = (CardView) findViewById(R.id.c6);
        card7 = (CardView) findViewById(R.id.c7);
        card8 = (CardView) findViewById(R.id.c8);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch ((v.getId())){
            case R.id.c1:
            case R.id.c2:
            case R.id.c3:
            case R.id.c4:
            case R.id.c5:
            case R.id.c6:
            case R.id.c7:
            case R.id.c8:
                i = new Intent(this,checkout.class);
                startActivity(i);
                break;

        }

    }
}