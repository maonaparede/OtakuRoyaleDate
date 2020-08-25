package com.example.otakuroyaledate;

import android.content.Context;
import android.media.MediaPlayer;


//Classe pai de todo o Sound efx
public class backMusicHandler {

   // private static backMusicHandler instance;
    private MediaPlayer mediaPlayer;
    private Context context;
    private String resource;

/*
    public static synchronized backMusicHandler getInstance() {
        if (instance == null) {
            instance = new backMusicHandler();
        }
        return instance;

    }

 */



    public void init(Context context, String resource) {
        this.context = context;
        this.resource = resource;

    }

    public void start(){

        if(mediaPlayer == null){
            startGeneral();
        }else{
            try {
                mediaPlayer.release();
                mediaPlayer = null;
                startGeneral();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void startGeneral(){
            if (resource != null) {
                String resName = resource.split("\\.")[2]; // remove the 'R.drawable.' prefix
                int resId = context.getResources().getIdentifier(resName, "raw", context.getPackageName());

                        mediaPlayer = MediaPlayer.create(context, resId);
                        mediaPlayer.start();
            }
    }

    public void play(){
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    public void pause(){
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
    }

    public void stop(){
        mediaPlayer.release();
    }



    public void finish(){

    }

}
