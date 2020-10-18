package com.example.otakuroyaledate.sound;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.otakuroyaledate.Game;
import com.example.otakuroyaledate.MainActivity;
import com.example.otakuroyaledate.utils.Cronos;
import com.example.otakuroyaledate.utils.CronosInterface;

import java.util.Timer;
import java.util.TimerTask;

public class SoundBackgroundHandler{

        //Seria legal ter um fade in e out

        public void start(Context context, String resource){
            Game.getSongBackground().init(context , resource , true);
            Game.getSongBackground().start();
        }

        public void play(){
            Game.getSongBackground().play();
        }

        public void pause(){
            Game.getSongBackground().pause();
        }

        public void stop(){
            Game.getSongBackground().stop();
        }


}
