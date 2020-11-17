package com.example.otakuroyaledate.audio;

import android.content.Context;
import android.util.Log;

import com.example.otakuroyaledate.R;
import com.huhx0015.hxaudio.audio.HXMusic;
import com.huhx0015.hxaudio.interfaces.HXMusicListener;
import com.huhx0015.hxaudio.model.HXMusicItem;


public class MusicPlayer extends HXMusic implements HXMusicListener {

    //The 'int' is a id that come from R.raw.(some music name)
    private int music;
    private Context context;



    public MusicPlayer init(Context context, int music){
        this.context = context;
        this.music = music;


        //Somehow this is necessary, to make this work
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


    public void resumeM(Context context1){
        HXMusic.resume(context1);
    }

    public void pauseM(){
        HXMusic.pause();
    }

    public void stopM(){
        HXMusic.stop();
    }





    @Override
    public void onMusicPrepared(HXMusicItem hxMusicItem) {

    }


    //Go to the next Music when the actual ends
    @Override
    public void onMusicCompletion(HXMusicItem hxMusicItem) {
        new Playlist(context).nextMusic();
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
