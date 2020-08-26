package com.example.otakuroyaledate.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;

//vai ser usado em um dos tipos de telas finais, como cronometro pro user escolher qual
//decisão tomar
public class Cronos {
    public CronosInterface cronosInterface;
    private CountDownTimer count;
    private long millisPassed;
    private long millisInit;
    private Boolean isRunning;
    private Boolean isFinish;

    public Cronos(CronosInterface cronosInterface1 , int milisecond) {
        millisInit = milisecond;
        cronosInterface = cronosInterface1;
        isRunning = false;
    }

    public void startOrPlay(){
        isFinish = false;
        if(isRunning){
            play();
        }else{
            start();
        }
    }

    private void start(){
        if(!isRunning) {
            count = new CountDownTimer(millisInit, 1000) {

                public void onTick(long millisUntilFinished) {
                    //   mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    millisPassed = millisUntilFinished;
                    cronosInterface.cronosUpdate(millisUntilFinished);
                    Log.d("Mili start", millisPassed + "");
                }

                public void onFinish() {
                    finish();
                }
            }.start();

            //isFinish = false;
        }
    }

    private void play(){
        if(isRunning) {
            count = new CountDownTimer( millisPassed, 1000) {
                public void onTick(long millisUntilFinished) {
                    //   mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    millisPassed = millisUntilFinished;
                    cronosInterface.cronosUpdate(millisUntilFinished);
                    Log.d("Mili play", millisPassed + "");
                }
                public void onFinish() {
                    finish();
                }
            }.start();
        }
    }

    public void pause(){
        if (count != null) {
            if (!isFinish) {
                Log.d("Mili pause", millisPassed + "");
                isRunning = true;
                count.cancel();
            } else {
                stop();
            }
        }
    }

    public void stop(){
        if (count != null) {
            Log.d("stop", millisPassed + "");
            isFinish = true;
            isRunning = false;
            millisPassed = 0;
            count.cancel();
            finish();
        }
    }



    public void finish(){
        isRunning = false;
        isFinish = true;
        isFinish();
        Log.d("Terminou" , "top");
    }

    public void isFinish(){
        cronosInterface.cronosFinish();
    }


}

