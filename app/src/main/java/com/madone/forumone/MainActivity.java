package com.madone.forumone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView forumpic;
    ListView listView;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        List<SetData> setData;
        setData = new ArrayList<>();
        setData.add(new SetData(getString(R.string.title_listitems), getString(R.string.description), "https://images.unsplash.com/photo-1623387641168-d9803ddd3f35?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"));
        setData.add(new SetData(getString(R.string.title_listitems2), getString(R.string.description2), "https://images.unsplash.com/photo-1560114928-40f1f1eb26a0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"));
        setData.add(new SetData(getString(R.string.title_listitems3), getString(R.string.description3), "https://images.unsplash.com/photo-1452857297128-d9c29adba80b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80"));
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.list_items, setData);
        listView.setAdapter(customAdapter);

        button = findViewById(R.id.FAB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }



        });
/*
        forumpic = findViewById(R.id.listImage);

        forumpic.setOnClickListener(new View.OnClickListener(){
            public void onClick

        }

*/
    }



}