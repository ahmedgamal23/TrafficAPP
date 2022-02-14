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

public class bus_details extends AppCompatActivity {

    TextView txt_num_bus , num_people;
    EditText edt_icrement;
    Button btn_icr , reg_confirm , btn_back;
    int num , sum , n;
    DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_details);

        txt_num_bus = findViewById(R.id.num_of_buses);
        num_people = findViewById(R.id.num_of_current);
        edt_icrement = findViewById(R.id.txt_increment);
        btn_back = findViewById(R.id.btn_back);
        reg_confirm = findViewById(R.id.btn_confirm);
        btn_icr = findViewById(R.id.increase_passengers);

        if(Main2Activity.num_of_bus == 0 || Main2Activity.num_of_bus == 1 || Main2Activity.num_of_bus == 2 || Main2Activity.num_of_bus == 3 )
        {
            txt_num_bus.setText("9");
        }
        btn_icr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Integer.parseInt(edt_icrement.getText().toString());
                sum = num + Integer.parseInt(num_people.getText().toString());
                if(sum > 26)
                {
                    Toast.makeText(getApplicationContext() , "Bus Complete" , Toast.LENGTH_LONG).show();
                    n = Integer.parseInt(txt_num_bus.getText().toString());
                    txt_num_bus.setText(String.valueOf(n--));
                    edt_icrement.setText("");
                }
                else
                    num_people.setText(String.valueOf(sum));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bus_details.this , Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        // to confirm reservation..
        reg_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent(bus_details.this, push_activity.class);
                    startActivity(i);
                    dBhelper.save_ticket(login_activity.usern, true);
                }catch (Exception E)
                {
                    Toast.makeText(getApplicationContext() , E.getMessage() , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
