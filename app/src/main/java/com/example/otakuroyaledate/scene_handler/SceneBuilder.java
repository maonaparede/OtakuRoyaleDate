package com.example.otakuroyaledate.scene_handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.otakuroyaledate.Game;
import com.example.otakuroyaledate.MainActivity;
import com.example.otakuroyaledate.itens_recyclerviews.Item_dialogue;

import java.io.IOException;
import java.io.InputStream;

public class SceneBuilder {

    private Context context;

    public SceneBuilder build() {
        this.context = Game.getContext();
        return this;
    }

    public SceneBuilder background(String imageResource) throws IOException {

        if(imageResource != null) {
            InputStream ims = context.getAssets().open("background/" + imageResource);
            Drawable d = Drawable.createFromStream(ims, null);

            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{
                    Game.getBackground().getDrawable(), d});

            Game.getBackground().setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(500);
        }

        return this;
    }


    public SceneBuilder imagePersonagem(String imageResource) throws IOException {

        if(imageResource != null) {

            InputStream ims = context.getAssets().open("characters/" + imageResource);
            Drawable d = Drawable.createFromStream(ims, null);

            Glide.with(context).load(d)
                    .transition(DrawableTransitionOptions.withCrossFade().crossFade(1500)).into(Game.getPersonagem());
        }
        return this;
    }


    public SceneBuilder dialogue(String text){

        if(!TextUtils.isEmpty(text)){
            Game.getAdapterDialogue().clear();
            Game.getAdapterDialogue().add(new Item_dialogue(text));
        }

        return this;
    }


    public SceneBuilder namePersonagem(String name){

        String nameB = Game.getNamePersonagem().getText().toString();
        if((!TextUtils.isEmpty(name)) && (!name.equals(nameB)) ) {

            Animation out = new AlphaAnimation(0.0f, 1.0f);
            out.setRepeatMode(Animation.REVERSE);
            out.setDuration(500);
            Game.getNamePersonagem().setText(name);
            Game.getNamePersonagem().setAnimation(out);
        }
        return this;
    }

}
