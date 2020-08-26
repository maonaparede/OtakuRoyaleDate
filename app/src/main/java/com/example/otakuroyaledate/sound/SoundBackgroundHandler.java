package com.example.otakuroyaledate.sound;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.otakuroyaledate.MainActivity;
import com.example.otakuroyaledate.utils.Cronos;
import com.example.otakuroyaledate.utils.CronosInterface;

import java.util.Timer;
import java.util.TimerTask;

public class SoundBackgroundHandler{

        //Seria legal ter um fade in e out

        public void start(Context context, String resource){
            MainActivity.getSongBackground().init(context , resource , true);
            MainActivity.getSongBackground().start();
        }

        public void play(){
            MainActivity.getSongBackground().play();
        }

        public void pause(){
           MainActivity.getSongBackground().pause();
        }

        public void stop(){
            MainActivity.getSongBackground().stop();
        }





}
