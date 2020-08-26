package com.example.otakuroyaledate;

import android.content.Context;
import android.media.MediaPlayer;




//Classe pai de todo o Sound efx
public class Sfx implements MediaPlayer.OnCompletionListener {


    private MediaPlayer mediaPlayer;
    private Context context;
    private String resource;
    private Boolean loop;

/*
    public static synchronized backMusicHandler getInstance() {
        if (instance == null) {
            instance = new backMusicHandler();
        }
        return instance;

    }

 */



    public void init(Context context, String resource, Boolean loop) {
        this.context = context;
        this.resource = resource;
        this.loop = loop;
    }

    public void start(){

        if(mediaPlayer == null){
            createMedia();
        }else{
            try {
                mediaPlayer.release();
                mediaPlayer = null;
                createMedia();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private void createMedia(){
            if (resource != null) {
                String resName = resource.split("\\.")[2]; // remove the 'R.drawable.' prefix
                int resId = context.getResources().getIdentifier(resName, "raw", context.getPackageName());

                        mediaPlayer = MediaPlayer.create(context, resId);
                        mediaPlayer.setOnCompletionListener(this);
                        play();
            }
    }



    public void play(){

        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }else{
            mediaPlayer.stop();
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

    @Override
    public void onCompletion(MediaPlayer mp) {

        if(loop) {
            createMedia();
        }else {
            finish();
        }
    }

    public void setVolume(float volume, float volume1) {
        mediaPlayer.setVolume(volume , volume1);
    }
}
