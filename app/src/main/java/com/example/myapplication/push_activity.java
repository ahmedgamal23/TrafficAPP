package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class push_activity extends AppCompatActivity {
    Button btn_cash , btn_visa;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_activity);


        btn_cash = findViewById(R.id.btn_pay_cash);
        btn_visa = findViewById(R.id.btn_pay_visa);
        btn_cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() , " Thanks for deal with you " , Toast.LENGTH_LONG).show();
                intent = new Intent(push_activity.this , qr_activity.class);
                startActivity(intent);
            }
        });

        btn_visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext() , " تم سحب المبلغ المطلوب شكرا " , Toast.LENGTH_LONG).show();
                intent = new Intent(push_activity.this , qr_activity.class);
                startActivity(intent);
            }
        });


    }
}
