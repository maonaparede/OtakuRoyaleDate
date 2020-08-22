package com.example.otakuroyaledate.objects;

import java.util.ArrayList;

public class Rotas {

    //Usado para pegar todas as cenas do Json
    private ArrayList<Scene> rotas;

    public Rotas(ArrayList<Scene> rotas) {
        this.rotas = rotas;
    }

    public ArrayList<Scene> getRotas() {
        return rotas;
    }

    public void setRotas(ArrayList<Scene> rotas) {
        this.rotas = rotas;
    }

    public Boolean addAllRotas(ArrayList<Scene> rotas){
       return this.rotas.addAll(rotas);
    }
}
