package com.example.dobit.rplife;

import android.app.Activity;
import android.app.Dialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DialogElima extends Activity{
    private ImageView mImgElima;
    private ImageView mImgSelectElima;
    private ImageView mImgCancelElima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialization_elima);
        init();
    }

    public void init(){
        mImgSelectElima = (ImageView)findViewById(R.id.imgSelectElima);
        mImgCancelElima = (ImageView)findViewById(R.id.imgElimaCancel);
    }
}
