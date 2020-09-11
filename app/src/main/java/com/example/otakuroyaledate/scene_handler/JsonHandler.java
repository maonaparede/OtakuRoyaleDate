package com.example.otakuroyaledate.scene_handler;


import android.content.Context;
import android.util.Log;

import com.example.otakuroyaledate.objects.AllRotas;
import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.objects.Rotas;
import com.example.otakuroyaledate.R;
import com.google.gson.stream.JsonReader;

import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class JsonHandler {

    private Context context;

    public JsonHandler(Context context) {
        this.context = context;
    }

    public ArrayList<String> getAllJson() throws IOException {
        InputStream inputStream = context.getResources().openRawResource(R.raw.all_rotes);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        JsonReader reader = new JsonReader(bufferedReader);
        //AllRotas = só uma ArrayList<String>
        AllRotas allRotas;
        allRotas = new Gson().fromJson(reader, AllRotas.class);

        return allRotas.getAllRotas();
    }

    //Transforma o arquivo Json em uma lista da Classe "Cene"
    //A classe Rotas é só um ArrayList de "Cene"
    //Os dados vão para O "CeneMap"
    public Rotas JsonToJava(String resource) throws IOException {

        String resName = resource.split("\\.")[2]; // remove the 'R.drawable.' prefix
        int resId = context.getResources().getIdentifier(resName, "raw", context.getPackageName());

        InputStream inputStream = context.getResources().openRawResource(resId);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        JsonReader reader = new JsonReader(bufferedReader);

        Rotas rotas;
        rotas = new Gson().fromJson(reader, Rotas.class);

        return rotas;
    }
}

