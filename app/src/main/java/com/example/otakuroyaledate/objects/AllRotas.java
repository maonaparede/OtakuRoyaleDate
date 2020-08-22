package com.example.otakuroyaledate.objects;

import java.util.ArrayList;


//Obj para pegar o nome de  todos os arquivos Json que estrturam a cena
public class AllRotas {

    private ArrayList<String> allRotas;

    public AllRotas(ArrayList<String> allRotas) {
        this.allRotas = allRotas;
    }

    public ArrayList<String> getAllRotas() {
        return allRotas;
    }

    public void setAllRotas(ArrayList<String> allRotas) {
        this.allRotas = allRotas;
    }
}
