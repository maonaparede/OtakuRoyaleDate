package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogGeneric;
import com.huhx0015.hxaudio.audio.HXSound;

public class Credits extends AppCompatActivity implements ConfirmationDialog {

    private String end;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        textView = findViewById(R.id.credits);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            message();
        }



    }


    private void message(){
        String message = "O desenvolvedor esqueceu de colocar uma mensagem final aqui, então... Obrigado por jogar";

        if(SceneMap.getCeneMapById(end) != null) {
            Scene scene = SceneMap.getCeneMapById(end);
            message = scene.getSaid();
        }


       DialogGeneric removeConfirmation = new DialogGeneric();

       removeConfirmation
               .createDialogRemoveConfirmation
                       (this, message , R.string.credits_title,this);
    }



    @Override
    public void DialogConfirmation() {

    }

    public void toHome(View v){
        //play the sfx
        HXSound.sound().load(R.raw.select_click_menu).play(this);
        //Send to main Activity and clear all the screen Before
        startActivity(new Intent(this , MainActivity.class).
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}