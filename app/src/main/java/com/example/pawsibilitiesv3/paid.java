package com.madexample.pawssibilities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class paid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid);
        final EditText NameOnCard = findViewById(R.id.NameOnCard);
        final EditText CardNumber = findViewById(R.id.CardNumber);
        final EditText ExpDate = findViewById(R.id.ExpDate);
        final EditText cvv = findViewById(R.id.cvv);
        final EditText MobileNo = findViewById(R.id.MobileNo);
        Button BtnSubmit = findViewById(R.id.BtnSubmit);

        DAOPayment dao = new DAOPayment();
        BtnSubmit.setOnClickListener(v->{
            Payment pay = new Payment(NameOnCard.getText().toString(),
                    CardNumber.getText().toString(),
                    ExpDate.getText().toString(),
                    cvv.getText().toString(),
                    MobileNo.getText().toString());

            dao.add(pay).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record Inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("NameOnCard",NameOnCard.getText().toString());
            hashMap.put("CardNumber",CardNumber.getText().toString());
            hashMap.put("ExpDate",ExpDate.getText().toString());
            hashMap.put("cvv",cvv.getText().toString());
            hashMap.put("MobileNo",MobileNo.getText().toString());
            dao.update("MkUNxdazy0RB7_x2",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
            dao.remove("MkUNxdazy0RB7_x2").addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record Removed", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }}
