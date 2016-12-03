package com.example.dobit.rplife;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dobit.rplife.Home.MainActivity;

public class CharacterCreationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFace;
    private Button btnHair;
    private Button btnBody;
    private Button btnClothes;
    ImageView imageView;
    private EditText txt_name;
    private ImageView mImgNextBtn;
    MediaPlayer homePageSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_character_creation);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/BebasNeue.ttf");
        imageView = (ImageView) findViewById(R.id.img_faces);
        btnFace = (Button) findViewById(R.id.btnFace);
        btnFace.setOnClickListener(this);
        btnFace.setTextColor(Color.parseColor("#fcbf40"));
        btnBody = (Button) findViewById(R.id.btnBody);
        btnBody.setOnClickListener(this);
        btnHair = (Button) findViewById(R.id.btnHair);
        btnHair.setOnClickListener(this);
        btnClothes = (Button) findViewById(R.id.btnClothes);
        btnClothes.setOnClickListener(this);
        txt_name = (EditText) findViewById(R.id.character_name);
        mImgNextBtn = (ImageView)findViewById(R.id.imgvNextBtn);
        btnFace.setTypeface(myCustomFont);
        btnClothes.setTypeface(myCustomFont);
        btnHair.setTypeface(myCustomFont);
        btnBody.setTypeface(myCustomFont);
        txt_name.setTypeface(myCustomFont);
        homePageSound = MediaPlayer.create(this, R.raw.welcome_back);
        mImgNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CharacterCreationActivity.this,MainActivity.class);
                startActivity(intent);
                homePageSound.start();
            }
        });



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFace:
                //method
                btnFace.setTextColor(Color.parseColor("#fcbf40"));
                btnBody.setTextColor(Color.parseColor("#efefef"));
                btnHair.setTextColor(Color.parseColor("#efefef"));
                btnClothes.setTextColor(Color.parseColor("#efefef"));

                imageView.setImageResource(R.drawable.faces);
                break;
            case R.id.btnBody:
                //method
                btnFace.setTextColor(Color.parseColor("#efefef"));
                btnBody.setTextColor(Color.parseColor("#fcbf40"));
                btnHair.setTextColor(Color.parseColor("#efefef"));
                btnClothes.setTextColor(Color.parseColor("#efefef"));

                imageView.setImageResource(R.drawable.body);
                break;
            case R.id.btnHair:
                //method
                btnFace.setTextColor(Color.parseColor("#efefef"));
                btnBody.setTextColor(Color.parseColor("#efefef"));
                btnHair.setTextColor(Color.parseColor("#fcbf40"));
                btnClothes.setTextColor(Color.parseColor("#efefef"));

                imageView.setImageResource(R.drawable.hair);
                break;
            case R.id.btnClothes:
                //method
                btnFace.setTextColor(Color.parseColor("#efefef"));
                btnBody.setTextColor(Color.parseColor("#efefef"));
                btnHair.setTextColor(Color.parseColor("#efefef"));
                btnClothes.setTextColor(Color.parseColor("#fcbf40"));

                imageView.setImageResource(R.drawable.clothes);
                break;
        }
    }
}
