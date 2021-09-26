package com.madone.forumone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity3 extends AppCompatActivity {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("Image");
    private StorageReference reference = FirebaseStorage.getInstance().getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final EditText edit_title = findViewById(R.id.inputtitle);
        final EditText edit_des = findViewById(R.id.inputdes);
        final ImageButton edit_image = findViewById(R.id.insertimage);
        Button btn = findViewById(R.id.submitbtn);
        DAOpostsub dao =new DAOpostsub();
        //Button btn_open = findViewById()
    }
}