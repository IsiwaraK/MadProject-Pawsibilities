package com.madone.forumone;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    ImageButton uploadBtn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText edit_title = findViewById(R.id.inputtitle);
        final EditText edit_des = findViewById(R.id.inputdes);
        final ImageButton edit_image = findViewById(R.id.insertimage);
        Button btn = findViewById(R.id.submitbtn);
        Button btn_open=findViewById(R.id.yourposts);
        btn_open.setOnClickListener(z-> {

            Intent intent = new Intent(MainActivity2.this, RVactivity.class);
            startActivity(intent);

        });

        DAOpostsub dao =new DAOpostsub();
        Postsub post_edit = (Postsub)getIntent().getSerializableExtra("EDIT");
        if (post_edit != null)
        {
            btn.setText("UPDATE");
            btn.setTextSize(15);
            edit_title.setText(post_edit.getTitle());
            edit_des.setText(post_edit.getDescription());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn_open.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(v->
                {
                    Postsub post = new Postsub(edit_title.getText().toString(), edit_des.getText().toString());
                    if (post_edit == null
                    ) {

                        dao.add(post).addOnSuccessListener(suc ->
                        {
                            Toast.makeText(this, "posted", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                    }
                    else
                    {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("title", edit_title.getText().toString());
                        hashMap.put("description", edit_des.getText().toString());
                        dao.update(post_edit.getKey(),hashMap).addOnSuccessListener(suc ->
                        {
                            Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
                            finish();
                        }).addOnFailureListener(er ->
                        {
                            Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });

                    }

                });


        uploadBtn = findViewById(R.id.insertimage);
        uploadBtn.setOnClickListener(x ->mGetContet.launch("image/*"));

        }
        ActivityResultLauncher<String> mGetContet = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            uploadBtn.setImageURI(result);
                    }
                }

    });

}