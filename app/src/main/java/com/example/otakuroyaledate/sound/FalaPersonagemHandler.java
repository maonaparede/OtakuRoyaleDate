package com.example.otakuroyaledate.sound;

import android.content.Context;

import com.example.otakuroyaledate.Game;
import com.example.otakuroyaledate.MainActivity;

public class FalaPersonagemHandler extends SoundBackgroundHandler {


    @Override
    public void start(Context context, String resource) {
        Game.getAudioPersonagem().init(context , resource, false);
        Game.getAudioPersonagem().start();
        super.start(context, resource);
    }

    @Override
    public void play() {
        Game.getAudioPersonagem().start();
        super.play();
    }

    @Override
    public void pause() {
        Game.getAudioPersonagem().pause();
        super.pause();
    }

    @Override
    public void stop() {
        Game.getAudioPersonagem().stop();
        super.stop();
    }
}
