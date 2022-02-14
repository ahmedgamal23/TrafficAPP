package com.example.myapplication.chat_package;

//to store message..
public class message_model {
    // content two things
    // 1- message    2-  kind of send (bot , someone)
    private String message;
    private String send_man;

    public message_model(String msg , String s)
    {
        //to set data....
        this.message = msg;
        this.send_man = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSend_man() {
        return send_man;
    }

    public void setSend_man(String send_man) {
        this.send_man = send_man;
    }
}
