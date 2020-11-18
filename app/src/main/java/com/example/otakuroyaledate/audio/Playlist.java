package com.example.otakuroyaledate.audio;

import android.content.Context;


import com.example.otakuroyaledate.R;
import com.huhx0015.hxaudio.audio.HXMusic;
import com.huhx0015.hxaudio.interfaces.HXMusicListener;
import com.huhx0015.hxaudio.model.HXMusicItem;

public class Playlist extends MusicPlayer{

    private static Context context;
    private static Boolean initialized = false;

    private final static int[] musics =
            {R.raw.stone , R.raw.tatakae , R.raw.tatakae};

    private static int length = musics.length - 1;
    private static int position = 0;


    public Playlist(Context context) {
        Playlist.context = context;

        HXMusic.instance();
    }

    public void nextMusic(){
            initialized = true;
            nextMusicAuto();
    }

    private static void nextMusicAuto(){
        if(position <= length) {
            new MusicPlayer().init(context, musics[position]).start();
            position++;
        }else{
            position = 0;
            nextMusicAuto();
        }
    }

    public Boolean isInitialized(){

        return initialized;
    }

}
