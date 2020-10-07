package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;
import com.example.otakuroyaledate.utils.Cronos;
import com.example.otakuroyaledate.utils.CronosInterface;

import java.io.IOException;
import java.io.InputStream;

public class EndImage extends AppCompatActivity implements CronosInterface {

    private ImageView image;
    private Cronos cronos;
    private String end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_image);

        image = findViewById(R.id.background_end_image);
        cronos = new Cronos(this , 12);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            try {
                setScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void setScene() throws IOException {
        Scene scene = SceneMap.getCeneMapById(end);
        String image2 = scene.getImgCene();

        InputStream ims = getAssets().open("background/" + image2);
        Drawable d = Drawable.createFromStream(ims, null);

        Glide.with(this).load(d).into(image);
    }

    @Override
    public void cronosFinish() {

    }
}