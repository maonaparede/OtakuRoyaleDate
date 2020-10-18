package com.example.otakuroyaledate.sound;

import android.content.Context;

import com.example.otakuroyaledate.Game;
import com.example.otakuroyaledate.MainActivity;

public class SoundEfeitoHandler extends SoundBackgroundHandler {

    @Override
    public void start(Context context, String resource) {
        Game.getEfeitos().init(context , resource, false);
        Game.getEfeitos().start();
        super.start(context, resource);
    }

    @Override
    public void play() {
        Game.getEfeitos().start();
        super.play();
    }

    @Override
    public void pause() {
        Game.getEfeitos().pause();
        super.pause();
    }

    @Override
    public void stop() {
        Game.getEfeitos().stop();
        super.stop();
    }

}
