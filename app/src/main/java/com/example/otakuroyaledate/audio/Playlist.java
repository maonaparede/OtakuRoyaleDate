package com.example.otakuroyaledate.audio;

import android.content.Context;


import com.example.otakuroyaledate.R;
import com.huhx0015.hxaudio.interfaces.HXMusicListener;
import com.huhx0015.hxaudio.model.HXMusicItem;

public class Playlist {

    private static Context context;

    private final static int[] musics =
            {R.raw.stone , R.raw.tatakae , R.raw.tatakae};

    private static int length = musics.length - 1;
    private static int position = 0;


    public Playlist(Context context) {
        Playlist.context = context;
    }

    public void nextMusic(){
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


}
