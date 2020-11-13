package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;

import java.io.IOException;
import java.io.InputStream;

public class ImageOnly extends AppCompatActivity {

    private ImageView image;
    private String end;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        image = findViewById(R.id.background_end_image);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            try {
                setScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Log.e("Dev miss: ", "Where are the Scene Bro? You Forgot ");
        }



    }

    private void setScene() throws IOException {
        try {
            Scene scene = SceneMap.getCeneMapById(end);
            String image2 = scene.getImgCene();


        InputStream ims = getAssets().open("background/" + image2);
        Drawable d = Drawable.createFromStream(ims, null);

        Glide.with(this).load(d).into(image);

    }catch (Exception e){
            Log.e("Dev miss: ", "Something in this image scene went wrong : " , e);
    }
    }

    public void clickImage(View view){
        Intent intent = new Intent(this , Credits.class);
        intent.putExtra("end" , end);
        startActivity(intent);
    }

}