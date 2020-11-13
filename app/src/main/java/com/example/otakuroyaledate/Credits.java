package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogGeneric;

public class Credits extends AppCompatActivity implements ConfirmationDialog {

    private String end;
    private TextView textView;
    private static MediaPlayer mediaPlayer;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        textView = findViewById(R.id.credits);
        context = this;


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            message();
        }


        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tatakae);

        //mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                toCredits();
            }
        });
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
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }


    private void toCredits() {
        mediaPlayer.stop();
    }


    @Override
    public void DialogConfirmation() {

    }

    public void toHome(View v){
        //Send to main Activity and clear all the screen Before
        startActivity(new Intent(this , MainActivity.class).
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}