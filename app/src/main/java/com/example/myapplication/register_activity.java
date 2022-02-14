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

public class register_activity extends AppCompatActivity {

    EditText username , email , passwored , comfirm_password , f_name , l_name , phone , nick_name;
    Button btn_register;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        username=(EditText)findViewById(R.id.editTextTextPersonName3) ;
        email =(EditText)findViewById(R.id.editTextTextPersonName4) ;
        passwored =(EditText)findViewById(R.id.editTextTextPersonName5) ;
        comfirm_password=(EditText)findViewById(R.id.editTextTextPersonName6) ;
        f_name = (EditText) findViewById(R.id.editTextTextPersonName7);
        l_name = (EditText) findViewById(R.id.editTextTextPersonName8);
        phone = (EditText) findViewById(R.id.editTextTextPersonName9);
        nick_name = (EditText) findViewById(R.id.editTextTextPersonName10);

        btn_register=(Button)findViewById(R.id.button3);
        DB=new DBhelper(this);
        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String user=username.getText().toString();
                String email1=email.getText().toString();
                String pass=passwored.getText().toString();
                String com_pass=comfirm_password.getText().toString();

                if (user.equals("")||email1.equals("")||pass.equals("")||com_pass.equals(""))
                {
                    Toast.makeText(register_activity.this,"please fill all fields.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(com_pass))
                    {
                        boolean result1= DB.checkusername(user);
                        if (result1 == false)
                        {
                            boolean result2=DB.insertdata(f_name.getText().toString() , l_name.getText().toString() , user , email1 , pass , Integer.parseInt(phone.getText().toString()) , nick_name.getText().toString() );
                            if(result2==false)
                            {
                                Toast.makeText(register_activity.this,"Registration failed.",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(register_activity.this,"Registration successful.",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),login_activity.class);
                                startActivity(intent);
                            }
                        }
                        else
                        {
                            Toast.makeText(register_activity.this,"user already exist.\n please login.",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(register_activity.this,"password does not match.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Button btn = findViewById(R.id.btn_log);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v) {
                Intent intent=new Intent(register_activity.this,login_activity.class);
                startActivity(intent);
            }
        });

    }

}
