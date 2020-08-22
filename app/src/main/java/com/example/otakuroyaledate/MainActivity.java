package com.example.otakuroyaledate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otakuroyaledate.scene_handler.JsonHandler;
import com.example.otakuroyaledate.scene_handler.SceneHandler;
import com.example.otakuroyaledate.itens_recyclerviews.Item_dialogue;
import com.example.otakuroyaledate.itens_recyclerviews.Item_option;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static ImageView background;
    private static ImageView personagem;
    private static TextView namePersonagem;
    private RecyclerView recyclerDialogue;
    private static GroupAdapter adapterDialogue;
    private RecyclerView recyclerOptions;
    private static GroupAdapter adapterOptions;
    private static Context context;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personagem = findViewById(R.id.personagem);
        background = findViewById(R.id.backgroud);
        namePersonagem = findViewById(R.id.name_personagem);
        recyclerDialogue = findViewById(R.id.recyclerview_dialogue);
        recyclerOptions = findViewById(R.id.recyclerview_options);
        adapterDialogue = new GroupAdapter();
        recyclerDialogue.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
        recyclerDialogue.setAdapter(adapterDialogue);
        adapterOptions = new GroupAdapter();
        recyclerOptions.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
        recyclerOptions.setAdapter(adapterOptions);

        context = this;

        adapterOptions.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
            optionSelected(item, view);
            }
        });

        try {
            SceneHandler er = new SceneHandler();
            er.init(this);
            SceneHandler.nextCene("1");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new JsonHandler(this).getAllJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void click(View view){
        SceneHandler.nextCene("1");

        return;
    }



    private void optionSelected(Item item , View view){
        Item_option option = (Item_option) item;
        String key = option.getIdKey();
        Log.d("Key" , key);


        if(key.substring(0, 1).equals("@")){
            toEndScreen(key);
        }else{
            SceneHandler.nextCene(key);
            return;
        }

    }




    public void toEndScreen(String end){
        Intent intent = new Intent(context, EndScreen.class);
        intent.putExtra("end", end);
        context.startActivity(intent);
    }

    public static ImageView getBackground() {
        return background;
    }

    public static ImageView getPersonagem() {
        return personagem;
    }

    public static TextView getNamePersonagem() {
        return namePersonagem;
    }

    public static GroupAdapter getAdapterDialogue() {
        return adapterDialogue;
    }

    public static GroupAdapter getAdapterOptions() {
        return adapterOptions;
    }

    public static Context getContext() {
        return context;
    }
}