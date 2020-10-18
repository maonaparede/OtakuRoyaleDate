package com.example.otakuroyaledate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.otakuroyaledate.itens_recyclerviews.Item_option;
import com.example.otakuroyaledate.scene_handler.JsonHandler;
import com.example.otakuroyaledate.scene_handler.SceneHandler;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.io.IOException;

public class Game extends AppCompatActivity {


    private static ImageView background;
    private static ImageView personagem;
    private static TextView namePersonagem;
    private RecyclerView recyclerDialogue;
    private static GroupAdapter adapterDialogue;
    private RecyclerView recyclerOptions;
    private static GroupAdapter adapterOptions;
    private static Context context;


    public static Sfx songBackground;
    public static Sfx audioPersonagem;
    public static Sfx efeitos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


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


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String id = bundle.getString("id");

            SceneHandler er = new SceneHandler();
            er.init(this);
            SceneHandler.nextCene(id);
        }

        // startActivity(new Intent(this , EndVideo.class).putExtra("end","27"));

        

    }



    // Integer count = 0;
    /*
    public void click(View view){
        //SceneHandler.nextCene("1");
        SoundBackgroundHandler rea = new SoundBackgroundHandler();
        if(count == 0) {

            rea.start(this, "R.raw.stone");
            count++;
        }else{
           // rea.pause();
            count = 0;
        }

        return;
    }
     */



    private void optionSelected(Item item , View view){
        Item_option option = (Item_option) item;
        String key = option.getIdKey();
        Log.d("Cene ID" , key);

        if(key.substring(0, 1).equals("@")){
            toEndScreen(key);
        }else{
            SceneHandler.nextCene(key);
            //save id from scene to continue
            SharedPreferences shared = getSharedPreferences("info",MODE_PRIVATE);
            shared.edit().putString("id" , key).apply();
            return;
        }
    }




    public void toEndScreen(String end){
        if(end.substring(0,2).equals("@v")){
            Intent intent = new Intent(context, EndVideo.class);
            intent.putExtra("end", end);
            context.startActivity(intent);
        }else
        if(end.substring(0,2).equals("@i")){
            Intent intent = new Intent(context, EndImage.class);
            intent.putExtra("end", end);
            context.startActivity(intent);
        }else{
            Intent intent = new Intent(context, Credits.class);
            intent.putExtra("end", end);
            context.startActivity(intent);
        }
    }


    public static Sfx getAudioPersonagem() {
        return audioPersonagem;
    }

    public static Sfx getEfeitos() {
        return efeitos;
    }

    public static Sfx getSongBackground() {
        return songBackground;
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