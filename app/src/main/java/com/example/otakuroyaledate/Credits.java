package com.example.otakuroyaledate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.example.otakuroyaledate.itens_recyclerviews.Item_credits;
import com.example.otakuroyaledate.itens_recyclerviews.Item_dialogue;
import com.example.otakuroyaledate.objects.Scene;
import com.example.otakuroyaledate.scene_handler.SceneMap;
import com.example.otakuroyaledate.utils.ConfirmationDialog;
import com.example.otakuroyaledate.utils.DialogGeneric;
import com.example.otakuroyaledate.utils.SpeedyLinearLayoutManager;
import com.huhx0015.hxaudio.audio.HXSound;
import com.xwray.groupie.GroupAdapter;

public class Credits extends AppCompatActivity implements ConfirmationDialog {

    private String end;
    private Spanned text;
    private RecyclerView recycler;
    private static GroupAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        recycler = findViewById(R.id.credits_recycler);
        adapter = new GroupAdapter();
        recycler.setLayoutManager(new SpeedyLinearLayoutManager(this, SpeedyLinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);


        recycler.setScrollContainer(true);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            end = bundle.getString("end");
            message();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
           text = Html.fromHtml(getString(R.string.credits), Html.FROM_HTML_MODE_LEGACY);
        } else {
            text = Html.fromHtml(getString(R.string.credits));
        }

        adapter.add(new Item_credits(text));

    }



    private void message(){
        String message = getString(R.string.credits_message);

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
        recycler.smoothScrollToPosition(adapter.getItemCount());
    }

    public void toHome(View v){
        //play the sfx
        HXSound.sound().load(R.raw.select_click_menu).play(this);
        //Send to main Activity and clear all the screen Before
        startActivity(new Intent(this , MainActivity.class).
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}