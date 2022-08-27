package com.example.myapplication;

public class exercise {
    private  String bodyPart;
    private  String equipment;
    private  String gifUrl;
    private  String ExrciseId;
    private  String name;
    private  String target;
    public   String gifurl;

    public exercise(String bodypart, String equipment, String gifurl, String ExrciseId, String name, String target) {
        this.bodyPart = bodypart;
        this.equipment = equipment;
        this.gifUrl = gifurl;
        this.ExrciseId = ExrciseId;
        this.name = name;
        this.target = target;
    }
        public String getBodyPart() {
            return bodyPart;
        }

        public void setBodyPart(String bodyPart) {
            this.bodyPart = bodyPart;
        }

        public String getEquipment() {
            return equipment;
        }

        public void setEquipment(String equipment) {
            this.equipment = equipment;
        }

        public String getGifUrl() {
            return gifUrl;
        }

        public void setGifUrl(String gifUrl) {
            this.gifUrl = gifUrl;
        }

        public String getId() {
            return ExrciseId;
        }

        public void setId(String id) {
            this.ExrciseId = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }



    }

