package com.example.dobit.rplife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.roger.gifloadinglibrary.GifLoadingView;

import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifImageView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity{
    private GifLoadingView mGifLoadingView;
    GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mGifLoadingView = new GifLoadingView();
        mGifLoadingView.setImageResource(R.drawable.logo1);
        mGifLoadingView.show(getFragmentManager(), "");
        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(6000);
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

}
