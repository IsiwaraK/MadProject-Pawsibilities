package com.example.pawsibilitiesv3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class VetDurationActivity extends AppCompatActivity {
    Button btnBirth,btnToday,btCalculate;

    TextView tvResult;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_duration);


        btnBirth = findViewById(R.id.bt_birth);
        btnToday = findViewById(R.id.btn_today);
        btCalculate = findViewById(R.id.btn_cal);
        tvResult = findViewById(R.id.tv_result);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        btnToday.setText(date);

        btnBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        VetDurationActivity.this
                        , android.R.style.Theme_Holo_Dialog_MinWidth
                        ,dateSetListener1,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = dayOfMonth + "/" + month + "/" + year;
                btnBirth.setText(date);
            }
        };



        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        VetDurationActivity.this
                        , android.R.style.Theme_Holo_Dialog_MinWidth
                        ,dateSetListener2,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = dayOfMonth + "/" + month + "/" + year;
                btnToday.setText(date);
            }
        };


        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sDate = btnBirth.getText().toString();
                String eDate = btnToday.getText().toString();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date1 = simpleDateFormat1.parse(sDate);
                    Date date2 = simpleDateFormat1.parse(eDate);

                    long startDate = date1.getTime();
                    long endDate = date2.getTime();

                    if(startDate <= endDate){
                        org.joda.time.Period period = new org.joda.time.Period(startDate,endDate,PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        tvResult.setText(years+" Years | "+months+" Months | "+days+" Days");
                    }else {
                        Toast.makeText(getApplicationContext()
                        ,"Last Vet Visit Date Should not be larger than todays date"
                        ,Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}