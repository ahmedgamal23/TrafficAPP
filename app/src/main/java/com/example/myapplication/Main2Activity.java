package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static  double Lat1 , Lng1 , Lat2 , Lng2;
    Intent i , intent;
    ListView listView;
    public static int num_of_bus ;
    String [] list_buses_name = {
                                    " مينى باص87 " , " مينى باص88 " , " مينى باص89 " , " مينى باص90 " , " مينى باص70" , "مينى باص50 " , " مينى باص80" , " مينى باص66" , " مينى باص101" , "مينى باص95 "
                                };
    String [] List_buses_details = {
                                        " مساكن أسكوالتجمع الاول " , " مساكن أسكوالسيدة عائشة " , " مساكن أسكوالسيدة نفيسة " , " مساكن أسكو ميدان الجيزة " , " مساكن إسكو القطامية " ,
                                        " زنين  الرحاب - بوابة 6 " , " مساكن أسكو - مستشفى الحسين " , " مدينة الطلبة -  الحى الثامن  " , " دوران شبرا التجمع الاول " , "  احمد حلمي - مدينه العبور "
                                      };
    int image_src = R.drawable.bus_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.id_list_view);
        adapter_list adapterList = new adapter_list(this , list_buses_name ,List_buses_details , image_src );
        listView.setAdapter(adapterList);

        // when click on listView item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 30.06067436815877;
                    Lng2 = 31.455094472116198;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 1)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 30.027415697483736;
                    Lng2 = 31.255966256860596;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 2)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 30.022486363781322;
                    Lng2 = 31.252138900326727;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 3)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 30.01544841772696;
                    Lng2 = 31.211965089405084;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 4)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 29.97709759082316;
                    Lng2 = 31.403773608657094;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 5)
                {
                    Lat1 = 30.03868895727426;
                    Lng1 = 31.18241033965606;
                    Lat2 = 30.053736390747627;
                    Lng2 = 31.490556271874897;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 6)
                {
                    Lat1 = 30.151142;
                    Lng1 = 31.277390;
                    Lat2 = 30.045088325635678;
                    Lng2 = 31.266190128589813;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 7)
                {
                    Lat1 = 30.068949063391123;
                    Lng1 = 31.201482242589208;
                    Lat2 = 30.05948847929461;
                    Lng2 = 31.358156024403723;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 8)
                {
                    Lat1 = 30.07977886302927;
                    Lng1 = 31.245175484850865;
                    Lat2 = 30.060692935644077;
                    Lng2 = 31.455126657659633;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }
                else if(i == 9)
                {
                    Lat1 = 30.05755453570833;
                    Lng1 = 31.246189871050973;
                    Lat2 = 30.22051758652254;
                    Lng2 = 31.466281703926544;
                    intent = new Intent(Main2Activity.this , main_map.class);
                    startActivity(intent);
                }

            }
        });


    }

    // Class : adapter class (listView)
    class adapter_list extends ArrayAdapter<String>
    {
        Context context;
        String [] title ;
        String [] description ;
        int img;

        adapter_list(Context c , String [] title , String [] description , int img)
        {
            super(c , R.layout.row_layout , title);
            this.context = c;
            this.title = title;
            this.description = description;
            this.img = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view_row = layoutInflater.inflate(R.layout.row_layout , parent , false);
            ImageView imageView = view_row.findViewById(R.id.imageView_icon);
            TextView textView_T = view_row.findViewById(R.id.txt_title);
            TextView textView_D = view_row.findViewById(R.id.txt_details);

            // to set data
            imageView.setImageResource(R.drawable.bus_icon);
            textView_T.setText(title[position]);
            textView_D.setText(description[position]);

            return view_row;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //to put main_menu in Main2Activity..
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu , menu);
        return true;
    }
    //when choose item from menu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home_id)
        {
            i = new Intent(this, Main2Activity.class);
            finish(); // to close current page
            startActivity(i);
        }
        else if(id == R.id.profile_id)
        {
            i = new Intent(this, my_profile.class);
            finish();
            startActivity(i);
        }
        else if(id == R.id.contact_id)
        {
            i = new Intent(this, chat.class);
            finish();
            startActivity(i);
        }
        else if(id == R.id.about_id)
        {
            i = new Intent(this, about.class);
            finish();
            startActivity(i);
        }
        else if(id == R.id.exit_id)
        {
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
        return super.onOptionsItemSelected(item);
    }
}
