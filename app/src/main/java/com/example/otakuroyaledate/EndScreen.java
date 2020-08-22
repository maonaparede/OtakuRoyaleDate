package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    private String end;
    private TextView textView;
    private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        Bundle b = new Bundle();
        b = getIntent().getExtras();
        end = b.getString("end");

        textView = findViewById(R.id.end_fallen);
        textView.setText(end);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tatakae );

        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                toCredits();
            }
        });
    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }

    public void onfinal(View view){
        toCredits();
    }

    private void toCredits() {
        mediaPlayer.stop();
        textView.setText("Final");
    }
}