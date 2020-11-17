package com.example.otakuroyaledate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otakuroyaledate.audio.MusicPlayer;
import com.example.otakuroyaledate.audio.Playlist;
import com.example.otakuroyaledate.scene_handler.JsonHandler;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogGeneric;

public class MainActivity extends AppCompatActivity implements ConfirmationDialog {



    Integer teste = 0;

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


    //music Teste - ignorar
    public void clickteste(View v){
        if(teste == 0){
            //new MusicPlayer().init(this , R.raw.stone ).start();
             new Playlist(this).nextMusic();
            teste = 1;
        }else if(teste == 1){
            new Playlist(this).nextMusic();
           // new MusicPlayer().init(this , R.raw.tatakae ).start();
            teste = 2;
        }else{
            new MusicPlayer().pauseM();
            teste = 0;
        }
    }


    public void newGame(View v){
        String message = getResources().getString(R.string.new_game_message);
        new DialogGeneric()
                .createDialogRemoveConfirmation(this , message ,
                        R.string.new_game_title , this);
    }

    public void continueGame(View v){
        SharedPreferences shared = getSharedPreferences("info",MODE_PRIVATE);
        String id = shared.getString("id" , "");


        if(!id.trim().isEmpty()){
            startActivity(new Intent(this , Game.class).putExtra("id" , id));
        }else{
            Toast.makeText(this , R.string.not_saved_game , Toast.LENGTH_LONG).show();
        }
    }

    public void credits(View v){
        startActivity(new Intent(this , Credits.class));
    }

    @Override
    public void DialogConfirmation() {

        try {
            //Clear the saved id - reset to id 1
            SharedPreferences pref;
            pref = getSharedPreferences("info", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.clear().apply();
        } finally {
            SharedPreferences shared = getSharedPreferences("info",MODE_PRIVATE);
            shared.edit().putString("id" , "1").apply();
        }

        startActivity(new Intent(this , Game.class).putExtra("id" , "1"));
    }
}