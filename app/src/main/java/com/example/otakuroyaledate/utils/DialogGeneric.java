package com.example.otakuroyaledate.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.otakuroyaledate.R;
import com.example.otakuroyaledate.itens_recyclerviews.Item_dialogue;
import com.xwray.groupie.GroupAdapter;


public class DialogGeneric {


    public ConfirmationDialog confirmationInterface;
    private static GroupAdapter adapter;

    public void  createDialogRemoveConfirmation(final Context context,
                                                String content1,
                                                int title1,
                                                ConfirmationDialog confirmationInterface){

        this.confirmationInterface = confirmationInterface;

        LayoutInflater inflater =  LayoutInflater.from(context);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        View view1 = inflater.inflate(R.layout.dialog_generic, null);

        Button ok = view1.findViewById(R.id.dialog_ok_cancel_button_ok);

        TextView title = view1.findViewById(R.id.dialog_ok_cancel_textview_title);
        RecyclerView recyclerView = view1.findViewById(R.id.dialog_ok_cancel_recyclerview);
        title.setText(title1);

        adapter = new GroupAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        adapter.add(new Item_dialogue(content1));

        mBuilder.setView(view1);
        final AlertDialog dialog = mBuilder.create();



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                callFunction();

            }
        });

        dialog.show();
    }


    private void callFunction(){
        confirmationInterface.DialogConfirmation();
    }
}
