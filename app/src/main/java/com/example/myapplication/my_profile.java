package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.db.DBhelper;

import java.util.ArrayList;

public class my_profile extends AppCompatActivity {

    Button btn_upd , btn_bac;
    TextView txt_user_n , txt_nam , txt2_email , txt_phone_n , txt_nick;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_upd = findViewById(R.id.btn_upd);
        btn_bac = findViewById(R.id.bt_back);

        txt_user_n = findViewById(R.id.set_txt_username);
        txt_nam = findViewById(R.id.set_txt_name);
        txt2_email = findViewById(R.id.set_txt_email);
        txt_phone_n = findViewById(R.id.set_txt_phone);
        txt_nick = findViewById(R.id.set_txt_nick);

        // to show data
        try{
            db = new DBhelper(this);
            Cursor cursor = db.getData(login_activity.usern);
            if(cursor.getCount() == 0)
                Toast.makeText(getApplicationContext(), "No data" , Toast.LENGTH_LONG).show();
            else
            {
                while (cursor.moveToNext())
                {
                    txt_nam.setText(cursor.getString(0));
                    txt_user_n.setText(cursor.getString(2));
                    txt2_email.setText(cursor.getString(3));
                    txt_phone_n.setText(cursor.getString(5));
                    txt_nick.setText(cursor.getString(6));
                }
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // updata data of user
        btn_upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_profile.this , update_profile.class);
                startActivity(intent);
            }
        });

        //to return to Main2Activity
        btn_bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(my_profile.this ,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

}
