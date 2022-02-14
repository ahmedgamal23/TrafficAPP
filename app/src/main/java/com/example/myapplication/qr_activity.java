package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class qr_activity extends AppCompatActivity {

    ImageView qrimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_activity);

        qrimage = findViewById(R.id.qrplaceholder);

        QRGEncoder qrgEncoder = new QRGEncoder( login_activity.usern , null, QRGContents.Type.TEXT, 100);
        try {

            Bitmap qrbits = qrgEncoder.getBitmap();
            qrimage.setImageBitmap(qrbits);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext() , e.getMessage() , Toast.LENGTH_LONG).show();
        }
        //.............................. to exit
        Button btn_exit = findViewById(R.id.btn_Exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //to exit from System..
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
            //.......
            if (getIntent().getBooleanExtra("EXIT", false)) {
                finish();
                System.exit(0);
            }
            }
        });
    }

}
