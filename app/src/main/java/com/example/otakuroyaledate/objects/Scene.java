package com.example.otakuroyaledate.objects;


import java.util.ArrayList;

public class Scene {

    //objeto e atributos que compõe a cena
    private String id;
    private String imgP;
    private String imgCene;
    private String nameP;
    private String said;
    private ArrayList<OptioNameId> button;

    public Scene(String id, String imgP, String imgCene, String nameP, String said, ArrayList<OptioNameId> button) {
        this.id = id;
        this.imgP = imgP;
        this.imgCene = imgCene;
        this.nameP = nameP;
        this.said = said;
        this.button = button;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public String getImgCene() {
        return imgCene;
    }

    public void setImgCene(String imgCene) {
        this.imgCene = imgCene;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getSaid() {
        return said;
    }

    public void setSaid(String said) {
        this.said = said;
    }

    public ArrayList<OptioNameId> getButton() {
        return button;
    }

    public void setButton(ArrayList<OptioNameId> button) {
        this.button = button;
    }


}
