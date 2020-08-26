package com.example.otakuroyaledate.sound;

import android.content.Context;

import com.example.otakuroyaledate.MainActivity;

public class FalaPersonagemHandler extends SoundBackgroundHandler {


    @Override
    public void start(Context context, String resource) {
        MainActivity.getAudioPersonagem().init(context , resource, false);
        MainActivity.getAudioPersonagem().start();
        super.start(context, resource);
    }

    @Override
    public void play() {
        MainActivity.getAudioPersonagem().start();
        super.play();
    }

    @Override
    public void pause() {
        MainActivity.getAudioPersonagem().pause();
        super.pause();
    }

    @Override
    public void stop() {
        MainActivity.getAudioPersonagem().stop();
        super.stop();
    }
}
