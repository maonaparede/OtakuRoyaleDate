package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;

import java.io.IOException;

//Só fiz no caso precise, mas a principio não quero usar não

public class VideoOnly extends AppCompatActivity {

    private VideoView videoView;
    private  MediaController mediaController;
    private Uri uri;
    private String end;
    private Scene scene;

    //Queria que carregasse vídeos do yt tb.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        videoView = findViewById(R.id.videoView);

        //Set MediaController  to enable play, pause, forward, etc options.
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Location of Media File
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            try {
                setVideo();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }else{
            Log.e("Dev miss: ", "Where are the Scene Bro? You Forgot ");
            finish();
        }


    }

    private void setVideo() throws IOException {
        scene = SceneMap.getCeneMapById(end);

        if(scene != null) {
            if (scene.getImgCene() != null) {
                String video = scene.getImgCene();

                //Pega o arquivo do Raw e seta como URI
                int id = this.getResources().getIdentifier(video, "raw", this.getPackageName());
                uri = Uri.parse("android.resource://" + getPackageName() + "/" + id);
                //Starting VideView By Setting MediaController and URI
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        endVideo();
                    }
                });
            } else {
                Log.e("Dev miss: ", "You don't set the video on Json file");
            }
        }else{
            Log.e("Dev miss: ", "Verify the name of the Scene in Json files");
            finish();
        }
    }

    private void endVideo(){
        Intent intent = new Intent(this , Credits.class);
        intent.putExtra("end" , end);
        startActivity(intent);
    }


}