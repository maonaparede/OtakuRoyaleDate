package com.example.otakuroyaledate.scene_handler;

import com.example.otakuroyaledate.Game;
import com.example.otakuroyaledate.MainActivity;
import com.example.otakuroyaledate.objects.OptioNameId;
import com.example.otakuroyaledate.itens_recyclerviews.Item_option;

import java.util.ArrayList;

public class RecyclerOptionHadler {

    public void addButton(String text , String id){
        Game.getAdapterOptions().add(new Item_option(text , id));
    }

    public void addAllButtons(ArrayList<OptioNameId> optioNameIds){

        if(optioNameIds != null) {
            for (OptioNameId button : optioNameIds) {

                Game.getAdapterOptions().add(new Item_option(button.getName(), button.getId()));
            }

        }
    }

    public void clearRecycler(){
        Game.getAdapterOptions().clear();
    }
}
