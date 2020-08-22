package com.example.otakuroyaledate.scene_handler;

import android.content.Context;
import android.util.Log;

import com.example.otakuroyaledate.objects.AllRotas;
import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.objects.Rotas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SceneMap {

    private static Map<String , Scene> ceneMap;
    //private Context context;

    //Pega o Json e transforma em "Rotas" (ArrayList de "Cene")
    public void transformJsonIntoRotas(Context context){


        AllRotas allRotas = new AllRotas(new ArrayList<String>());
        Rotas rotas = new Rotas(new ArrayList<Scene>());
        JsonHandler jsonHandler = new JsonHandler(context);
        try {
            //pega o primeiro o nome dos Jsons q serão usados no jogo, tipo R.raw.novel
            allRotas.setAllRotas(jsonHandler.getAllJson());
            //Depois pega o arquivo pelo nome e adiciona na lista rotas
            for (String rts: allRotas.getAllRotas()) {
                rotas.addAllRotas(new JsonHandler(context).JsonToJava(rts).getRotas());
            }

            //Função que passa a lista Rotas para o HashMap (Tipo um BD temporário, uma tabela)
            setCeneMap(rotas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //coloca no Hash map
    private void setCeneMap(Rotas rotas){
        ceneMap = new HashMap<String , Scene>();

        if(rotas != null){
            for (Scene scene : rotas.getRotas()){
                ceneMap.put(scene.getId() , scene);
            }
        }else{
            Log.d("CenaHandler" , "Erro! Rotas Vazias");
        }
    }


    public static Scene getCeneMapById(String id) {
        return ceneMap.get(id);
    }

    public static Map<String, Scene> getCeneMap() {
        return ceneMap;
    }
}
