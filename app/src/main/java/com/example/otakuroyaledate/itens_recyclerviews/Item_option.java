package com.example.otakuroyaledate.itens_recyclerviews;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.onbutton.OnButton;
import com.example.otakuroyaledate.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class Item_option extends Item<ViewHolder> {
    //item que vai na recycler view das opções. Ou seja, os botões msm
    private String textButton;
    private String idKey;

    public Item_option(String textDialogue , String id) {
        this.textButton = textDialogue;
        this.idKey = id;
    }

    @Override
    public void bind(@NonNull ViewHolder viewHolder, int position) {

        OnButton button = viewHolder.itemView.findViewById(R.id.option_button);

        button.setSoundEffectsEnabled(false);

        Animation out = new AlphaAnimation(0.0f, 1.0f);
        out.setRepeatMode(Animation.REVERSE);
        out.setDuration(1000);

        button.setText(textButton);
        button.setAnimation(out);
    }


    @Override
    public int getLayout() {
        return R.layout.item_buton_option;
    }

    public String getIdKey() {
        return idKey;
    }
}
