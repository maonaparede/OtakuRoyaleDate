package com.example.otakuroyaledate.scene_handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.otakuroyaledate.MainActivity;
import com.example.otakuroyaledate.itens_recyclerviews.Item_dialogue;

public class SceneBuilder {

    private Context context;

    public SceneBuilder build() {
        this.context = MainActivity.getContext();
        return this;
    }

    public SceneBuilder background(String imageResource){

        String resName = imageResource.split("\\.")[2]; // remove the 'R.drawable.' prefix
        int resId = context.getResources().getIdentifier(resName, "drawable", context.getPackageName());

        Drawable drawable = context.getResources().getDrawable(resId);

        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{
                MainActivity.getBackground().getDrawable() , drawable });

        MainActivity.getBackground().setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(500);

        return this;
    }


    public SceneBuilder imagePersonagem(String imageResource){

        if(imageResource != null) {
            String resName = imageResource.split("\\.")[2]; // remove the 'R.drawable.' prefix
            int resId = context.getResources().getIdentifier(resName, "drawable", context.getPackageName());

            Drawable drawable = context.getResources().getDrawable(resId);
            Glide.with(context).load(drawable)
                    .transition(DrawableTransitionOptions.withCrossFade().crossFade(1500)).into(MainActivity.getPersonagem());
        }
        return this;
    }


    public SceneBuilder dialogue(String text){

        if(!TextUtils.isEmpty(text)){
            MainActivity.getAdapterDialogue().clear();
            MainActivity.getAdapterDialogue().add(new Item_dialogue(text));
        }

        return this;
    }


    public SceneBuilder namePersonagem(String name){

        String nameB = MainActivity.getNamePersonagem().getText().toString();
        if((!TextUtils.isEmpty(name)) && (!name.equals(nameB)) ) {

            Animation out = new AlphaAnimation(0.0f, 1.0f);
            out.setRepeatMode(Animation.REVERSE);
            out.setDuration(500);
            MainActivity.getNamePersonagem().setText(name);
            MainActivity.getNamePersonagem().setAnimation(out);
        }
        return this;
    }

}
