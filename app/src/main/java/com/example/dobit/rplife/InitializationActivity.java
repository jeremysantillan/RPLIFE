package com.example.dobit.rplife;

import android.app.Activity;
import android.app.Dialog;
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

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class InitializationActivity extends AppCompatActivity {
    private ImageView mTvElima;
    private ImageView mTvErudite;
    private Button mBtnNext;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ///getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initialization);
        init();
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mTvElima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             final Dialog dialog = new Dialog(InitializationActivity.this,R.style.Theme_D1NoTitleDim);
                dialog.setContentView(R.layout.activity_initialization_elima);
                ImageView imgElimaSelect = (ImageView)dialog.findViewById(R.id.imgSelectElima);
                ImageView imgElimaCancel = (ImageView)dialog.findViewById(R.id.imgElimaCancel);
                dialog.getWindow().setLayout(1400,2000);
                dialog.show();

                imgElimaSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"You're an Elima!",Toast.LENGTH_SHORT).show();
                    }
                });

                imgElimaCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }

        });

        mTvErudite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(InitializationActivity.this,R.style.Theme_D1NoTitleDim);
                dialog.setContentView(R.layout.activity_initialization_erudite);
                ImageView imgEruditeSelect = (ImageView)dialog.findViewById(R.id.imgSelectErudite);
                ImageView imgEruditeCancel = (ImageView)dialog.findViewById(R.id.imgEruditeCancel);
                dialog.getWindow().setLayout(1400,2000);
                dialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
                dialog.show();

                imgEruditeSelect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"You're an Erudite!",Toast.LENGTH_SHORT).show();
                    }
                });

                imgEruditeCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InitializationActivity.this, CharacterCreationActivity.class);
                startActivity(intent);
            }
        });


    }

//<<<<<<< Updated upstream
    public void init() {
        mTvElima = (ImageView) findViewById(R.id.imgElima);
        mTvErudite = (ImageView) findViewById(R.id.imgErudite);
        mBtnNext = (Button) findViewById(R.id.btnNext);

//=======
    }
    private void nextActivity(){
        Intent intent = new Intent(InitializationActivity.this, CharacterCreationActivity.class);
        startActivity(intent);
//>>>>>>> Stashed changes
    }


}
