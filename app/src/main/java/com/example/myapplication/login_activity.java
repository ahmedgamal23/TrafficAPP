package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.db.DBhelper;

public class login_activity extends AppCompatActivity {

    EditText username,passwored;
    Button btn;
    Button btn_login;
    DBhelper DB;
    public static String usern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        username =(EditText)findViewById(R.id.editTextTextPersonName) ;
        passwored =(EditText)findViewById(R.id.editTextTextPersonName2) ;
        btn =(Button) findViewById(R.id.btn_reg);
        btn_login=(Button)findViewById(R.id.button);

        DB = new DBhelper(this);

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=passwored.getText().toString();
                if(user.equals("") ||pass.equals(""))
                {
                    Toast.makeText(login_activity.this,"please fill all fields.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try {
                        boolean result3 = DB.checkusernamepassword(user, pass);
                        if (result3 == true) {
                            usern = user;
                            Toast.makeText(login_activity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(login_activity.this, "invalid in your username or password", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        Toast.makeText(login_activity.this , e.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_activity.this,register_activity.class);
                startActivity(intent);
            }
        });
    }

}
