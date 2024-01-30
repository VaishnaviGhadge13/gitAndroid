package com.example.sampleapp;

import com.google.firebase.Timestamp;

public class Note //creating a module
{
    String Tittle;
    String Content;
    Timestamp timestamp; // This class from Firebase

    public Note() { // creating constructor

    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public com.google.firebase.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(com.google.firebase.Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
