package com.example.otakuroyaledate.itens_recyclerviews;

import android.text.Spanned;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.otakuroyaledate.R;
import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;

public class Item_credits extends Item<ViewHolder> {

        //item que vai na recycler view da fala do personagem. Só o texto msm
        private String textDialogue;
        private int intDialogue;
        private Spanned spanned;

    public Item_credits(String textDialogue) {
        this.textDialogue = textDialogue;
    }

    public Item_credits(int intDialogue){
        this.intDialogue = intDialogue;
    }

    public Item_credits(Spanned spanned){
        this.spanned = spanned;
    }

        @Override
        public void bind(@NonNull ViewHolder viewHolder, int position) {

        believe.cht.fadeintextview.TextView dialogue = viewHolder.itemView.findViewById(R.id.dialogue_text);
        dialogue.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        dialogue.setLetterDuration(10);
        if(spanned != null) {
            dialogue.setText(spanned);
        }else if(textDialogue != null){
            dialogue.setText(textDialogue);
        }else{
            dialogue.setText(intDialogue);
        }

    }


        @Override
        public int getLayout() {
        return R.layout.item_dialogue;
    }
}
