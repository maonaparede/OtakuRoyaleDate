package com.example.otakuroyaledate.itens_recyclerviews;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.otakuroyaledate.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class Item_dialogue extends Item<ViewHolder> {

    //item que vai na recycler view da fala do personagem. Só o texto msm
    private String textDialogue;
    private int intDialogue;

    public Item_dialogue(String textDialogue) {
        this.textDialogue = textDialogue;
    }

    public Item_dialogue(int intDialogue){
        this.intDialogue = intDialogue;
    }

    @Override
        public void bind(@NonNull ViewHolder viewHolder, int position) {

        believe.cht.fadeintextview.TextView dialogue = viewHolder.itemView.findViewById(R.id.dialogue_text);

            dialogue.setLetterDuration(50);
            if(textDialogue != null) {
                dialogue.setText(textDialogue);
            }else {
                dialogue.setText(intDialogue);
            }

        }


        @Override
        public int getLayout() {
            return R.layout.item_dialogue;
        }

}
