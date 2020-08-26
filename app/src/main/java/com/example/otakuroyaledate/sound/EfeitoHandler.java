package com.example.otakuroyaledate.sound;

import android.content.Context;

import com.example.otakuroyaledate.MainActivity;

public class EfeitoHandler extends SoundBackgroundHandler {

    @Override
    public void start(Context context, String resource) {
        MainActivity.getEfeitos().init(context , resource, false);
        MainActivity.getEfeitos().start();
        super.start(context, resource);
    }

    @Override
    public void play() {
        MainActivity.getEfeitos().start();
        super.play();
    }

    @Override
    public void pause() {
        MainActivity.getEfeitos().pause();
        super.pause();
    }

    @Override
    public void stop() {
        MainActivity.getEfeitos().stop();
        super.stop();
    }

}
