package com.example.otakuroyaledate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otakuroyaledate.scene_handler.JsonHandler;
import com.example.otakuroyaledate.scene_handler.SceneHandler;
import com.example.otakuroyaledate.itens_recyclerviews.Item_option;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogRemoveConfirmation;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

public class MainActivity extends AppCompatActivity implements ConfirmationDialog {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Loads all scenes from the JSON
        try {
            new JsonHandler(this).getAllJson();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void newGame(View v){
        new DialogRemoveConfirmation()
                .createDialogRemoveConfirmation(this , "Deseja Começar um novo Jogo?" +
                        "Todos os dados do seu jogo serão excluidos, tem certeza?" , "Novo Jogo" , this);
    }

    public void continueGame(View v){

        SharedPreferences shared = getSharedPreferences("info",MODE_PRIVATE);
        String id = shared.getString("id" , "");

        Log.d("ids top" , id );

        if(!id.trim().isEmpty()){
            startActivity(new Intent(this , Game.class).putExtra("id" , id));
        }else{
            Toast.makeText(this , "Você não possui nenhum jogo Salvo" , Toast.LENGTH_LONG).show();
        }
    }

    public void credits(View v){
        startActivity(new Intent(this , Credits.class));
    }

    @Override
    public void DialogConfirmation() {

        //Clear the saved id - reset to id 1
        SharedPreferences pref;
        pref = getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear().apply();

        startActivity(new Intent(this , Game.class).putExtra("id" , "1"));
    }
}