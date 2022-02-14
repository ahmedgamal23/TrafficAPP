package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.db.DBhelper;

public class update_profile extends AppCompatActivity {

    DBhelper dBhelper;
    Button btn_update , btn_back_to_pro;
    EditText e_f_name , e_l_name , e_pass , e_email , e_phone , e_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        dBhelper = new DBhelper(this);

        btn_back_to_pro = findViewById(R.id.bt_back_profile);
        btn_update = findViewById(R.id.bt_update);

        e_f_name = findViewById(R.id.et_first_name);
        e_l_name = findViewById(R.id.et_last_name);
        e_pass = findViewById(R.id.et_change_pass);
        e_email = findViewById(R.id.et_email);
        e_phone = findViewById(R.id.et_contact_no);
        e_nickname = findViewById(R.id.et_nick_name);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dBhelper.update_account(login_activity.usern, e_f_name.getText().toString(), e_l_name.getText().toString(), e_email.getText().toString(), e_pass.getText().toString(),
                            Integer.parseInt(e_phone.getText().toString()), e_nickname.getText().toString());
                    Intent intent = new Intent(update_profile.this, my_profile.class);
                    startActivity(intent);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), e.getMessage() , Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_back_to_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(update_profile.this, my_profile.class);
                startActivity(intent);
            }
        });

    }
}
