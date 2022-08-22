package com.example.myapplication;

public class User {
    public String bodypart , equipment , ExrciseId, name , target ;
    int gifurl;


    public User(String bodypart, String equipment, int gifurl, String ExrciseId, String name, String target) {
        this.bodypart = bodypart;
        this.equipment = equipment;
        this.gifurl = gifurl;
        this.ExrciseId = ExrciseId;
        this.name = name;
        this.target = target;
    }
}
