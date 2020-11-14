package com.example.otakuroyaledate;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.huhx0015.hxaudio.audio.HXMusic;
import com.huhx0015.hxaudio.builder.HXMusicBuilder;
import com.huhx0015.hxaudio.interfaces.HXMusicListener;
import com.huhx0015.hxaudio.model.HXMusicItem;

import java.io.IOException;


public class MusicPlayer extends HXMusic implements HXMusicListener {

    private int music;
   // private int id;
    private Context context;

    public MusicPlayer init(Context context, int music, Boolean loop){
        this.context = context;
        this.music = music;

        HXMusic.setListener(this);

        return this;
    }



    public void start() {
        if (HXMusic.isPlaying()) {
            try {
                stopM();
            }finally {
                play();
            }

        } else {
            play();
        }
    }

    private void play(){
       Log.e("dev" , "teste " + R.raw.stone);
        HXMusic.music().gapless(false).load(music).play(context);

    }


    public void resume(){
        HXMusic.resume(context);
    }

    public void pauseM(){
        HXMusic.pause();
    }

    public void stopM(){
        HXMusic.stop();
    }



    public void finish(){

    }


    @Override
    public void onMusicPrepared(HXMusicItem hxMusicItem) {

    }

    @Override
    public void onMusicCompletion(HXMusicItem hxMusicItem) {
        finish();
    }

    @Override
    public void onMusicBufferingUpdate(HXMusicItem hxMusicItem, int i) {

    }

    @Override
    public void onMusicPause(HXMusicItem hxMusicItem) {

    }

    @Override
    public void onMusicStop(HXMusicItem hxMusicItem) {

    }
}
