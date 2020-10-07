package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogRemoveConfirmation;

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

        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                toCredits();
            }
        });
    }


    private void message(){
        String message = "Fim";
        if(SceneMap.getCeneMapById(end) != null) {
            Scene scene = SceneMap.getCeneMapById(end);
            message = scene.getSaid();
        }

       DialogRemoveConfirmation removeConfirmation = new DialogRemoveConfirmation();

       removeConfirmation
               .createDialogRemoveConfirmation(this
                       , message , "Obrigado por Jogar!",this);
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
}