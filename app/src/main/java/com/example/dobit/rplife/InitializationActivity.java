package com.example.dobit.rplife;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mmin18.widget.RealtimeBlurView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class InitializationActivity extends AppCompatActivity {
    private ImageView mTvElima;
    private ImageView mTvErudite;
    AlertDialog alertDialog;
    private com.github.mmin18.widget.RealtimeBlurView blurView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initialization);
        init();
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mTvElima.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(InitializationActivity.this,R.style.Theme_D1NoTitleDim);

            @Override
            public void onClick(View v) {
                blurView.setVisibility(View.VISIBLE);
                dialog.setContentView(R.layout.activity_initialization_elima);
                ImageView imgElimaSelect = (ImageView)dialog.findViewById(R.id.imgSelectElima);
                ImageView imgElimaCancel = (ImageView)dialog.findViewById(R.id.imgElimaCancel);
                //dialog.getWindow().setLayout(1400,2000);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        blurView.setVisibility(View.INVISIBLE);
                    }
                });

                imgElimaSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"You're an Elima!",Toast.LENGTH_SHORT).show();
                    }
                });

                imgElimaCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                            blurView.setVisibility(View.INVISIBLE);
                        }
                    }
                });

            }

        });

        mTvErudite.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(InitializationActivity.this,R.style.Theme_D1NoTitleDim);


            @Override
            public void onClick(View v) {
                blurView.setVisibility(View.VISIBLE);
                dialog.setContentView(R.layout.activity_initialization_erudite);
                ImageView imgEruditeSelect = (ImageView)dialog.findViewById(R.id.imgSelectErudite);
                ImageView imgEruditeCancel = (ImageView)dialog.findViewById(R.id.imgEruditeCancel);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        blurView.setVisibility(View.INVISIBLE);
                    }
                });


                imgEruditeSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"You're an Erudite!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InitializationActivity.this, CharacterCreationActivity.class);
                        startActivity(intent);
                    }
                });

                imgEruditeCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                            blurView.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });


    }

//<<<<<<< Updated upstream
    public void init() {
        mTvElima = (ImageView) findViewById(R.id.imgElima);
        mTvErudite = (ImageView) findViewById(R.id.imgErudite);
        blurView = (RealtimeBlurView) findViewById(R.id.blurview);
    }
    private void nextActivity(){
        Intent intent = new Intent(InitializationActivity.this, CharacterCreationActivity.class);
        startActivity(intent);
//>>>>>>> Stashed changes
    }



}
