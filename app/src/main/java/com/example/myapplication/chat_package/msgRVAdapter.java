package com.example.myapplication.chat_package;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class msgRVAdapter extends RecyclerView.Adapter {

    // array list and context.
    private ArrayList<message_model> message_modal_ArrayList;
    private Context context;

    public msgRVAdapter(ArrayList<message_model> msg_model_ArrayList , Context context)
    {
        // constructor
        this.message_modal_ArrayList = msg_model_ArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType)
        {
            case 0:
                //viewType = 0 -->> someone send message..
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.create_message_me , parent , false);
                return new UserViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_layout, parent, false);
                return new BotViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // to set data to our layout file.
        message_model modal = message_modal_ArrayList.get(position);
        switch (modal.getSend_man()) {
            case "user":
                // set the text to our text view of user layout
                ((UserViewHolder) holder).user_txt.setText(modal.getMessage());
                break;
            case "bot":
                // to set the text to our text view of bot layout
                ((BotViewHolder) holder).bot_txt.setText(modal.getMessage());
                break;
        }
    }

    @Override
    public int getItemCount() {
        // return the size of array list
        return message_modal_ArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // is to set position.
        switch (message_modal_ArrayList.get(position).getSend_man()) {
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        // creating a variable
        // for our text view.
        TextView user_txt;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing with id.
            user_txt = itemView.findViewById(R.id.text_chat_message_me);
        }
    }

    public static class BotViewHolder extends RecyclerView.ViewHolder {

        // creating a variable
        // for our text view.
        TextView bot_txt;

        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            bot_txt = itemView.findViewById(R.id.text_chat_message_other);
        }
    }

}
