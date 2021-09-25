package com.example.pawsibilitiesv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText mobile;
    EditText province;
    EditText vurl;
    Button btnAdd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = (EditText)findViewById(R.id.txtName);
        mobile = (EditText)findViewById(R.id.txtMobile);
        email = (EditText)findViewById(R.id.txtEmail);
        province = (EditText)findViewById(R.id.txtProvince);
        vurl = (EditText)findViewById(R.id.txtimageurl);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });

    }
   private void insertData()
   {
       Map<String,Object> map = new HashMap<>();
       map.put("name",name.getText().toString());
       map.put("mobile",mobile.getText().toString());
       map.put("email",email.getText().toString());
       map.put("province",province.getText().toString());
       map.put("vurl",vurl.getText().toString());

       FirebaseDatabase.getInstance().getReference().child("veterinarians").push()
               .setValue(map)
               .addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {
                       Toast.makeText(AddActivity.this, "Data Inserted Succesfully !", Toast.LENGTH_SHORT).show();
                   }
               })
               .addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(Exception e) {
                       Toast.makeText(AddActivity.this, "Error Inserting Data !", Toast.LENGTH_SHORT).show();

                   }
               });
   }

   private void clearAll(){
        name.setText("");
        mobile.setText("");
        email.setText("");
        province.setText("");
        vurl.setText("");
   }

}