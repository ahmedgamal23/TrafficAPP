package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.chat_package.message_model;
import com.example.myapplication.chat_package.msgRVAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class chat extends AppCompatActivity {

    private RecyclerView chat_RV;
    private EditText user_msg_edt;
    private Button btn_send_msg;
    private final String User = "user";
    private final String Bot = "bot";

    // creating a variable for request queue.
    private RequestQueue requestQueue;
    // creating variable for class msgRVAdapter and ArrayList
    private msgRVAdapter msg_RV;
    private ArrayList<message_model> msg_model_arraylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chat_RV = findViewById(R.id.recycler_chat);
        user_msg_edt = findViewById(R.id.edit_chat_message);
        btn_send_msg = findViewById(R.id.button_chat_send);
        // to initialize our request queue.
        requestQueue = Volley.newRequestQueue(chat.this);
        requestQueue.getCache().clear();
        // create new array list
        msg_model_arraylist = new ArrayList<>();

        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // checke if the message entered by user or empty .
                if (user_msg_edt.getText().toString().isEmpty()) {
                    // if the edit text is empty display a toast message.
                    Toast.makeText( getApplicationContext() , "Please Enter Your Message " , Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to send message
                sendMessage(user_msg_edt.getText().toString());
                user_msg_edt.setText("");
            }
        });

        msg_RV = new msgRVAdapter(msg_model_arraylist , this);
        // create variable from linearLayoutManager..
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(chat.this, RecyclerView.VERTICAL, false);
        //connect between RecyclerView and LinearLayoutManager
        chat_RV.setLayoutManager(linearLayoutManager);
        //set adapter to RecycleView
        chat_RV.setAdapter(msg_RV);
    }

    private void sendMessage(String user_msg)
    {
        //pass message to arrayList
        msg_model_arraylist.add(new message_model(user_msg, User));
        msg_RV.notifyDataSetChanged();

        // url for bot Api
        String url = "http://api.brainshop.ai/get?bid=158777&key=u2V5O6jrD1ZzOyvF&uid=[uid]&msg=" + user_msg;
        // create a variable for request queue.
        RequestQueue queue = Volley.newRequestQueue(chat.this);

        // making a json object request for a get request and passing our url .
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    // get data from Json response and set this data in arrayList.
                    String bot_response = response.getString("cnt");
                    msg_model_arraylist.add(new message_model(bot_response, Bot));
                    // notify our adapter as data changed.
                    msg_RV.notifyDataSetChanged();
                }catch (JSONException e) {
                    e.printStackTrace();
                    // handling error response from bot.
                    msg_model_arraylist.add(new message_model("No response", Bot));
                    msg_RV.notifyDataSetChanged();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error handling.
                msg_model_arraylist.add(new message_model("hi my friend", Bot));
            }
        });
        // at last adding json object request to our queue.
        queue.add(jsonObjectRequest);
    }
}
