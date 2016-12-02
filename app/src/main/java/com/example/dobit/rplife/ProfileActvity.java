package com.example.dobit.rplife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mmin18.widget.RealtimeBlurView;

public class ProfileActvity extends AppCompatActivity {
    private ImageView mImgShop;
    private ImageView mImgInventory;
    private ImageView mImgAchieve;
    private ImageView mImgSkills;
    private com.github.mmin18.widget.RealtimeBlurView blur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actvity);
        init();
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


        mImgInventory.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(ProfileActvity.this,R.style.Theme_D1NoTitleDim);
            @Override
            public void onClick(View v) {
               //blur.setVisibility(View.VISIBLE);
                dialog.setContentView(R.layout.layout_inventory);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                      //  blur.setVisibility(View.INVISIBLE);
                        dialog.dismiss();
                    }
                });
            }
        });

        mImgShop.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(ProfileActvity.this,R.style.Theme_D1NoTitleDim);

            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.layout_shop);
                TextView loots = (TextView) dialog.findViewById(R.id.tvShopLoots);
                TextView potions = (TextView) dialog.findViewById(R.id.tvShopPotions);
                TextView weapons = (TextView) dialog.findViewById(R.id.tvWeaponsAndTools);
                final ImageView imageView = (ImageView) dialog.findViewById(R.id.imgvShopItems);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //  blur.setVisibility(View.INVISIBLE);
                        dialog.dismiss();
                    }
                });
                loots.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.shop_loot));
                    }
                });

                potions.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.shop_potions));
                    }
                });

                weapons.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.shop_weapons_and_tools));
                    }
                });
            }
        });

        mImgAchieve.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(ProfileActvity.this,R.style.Theme_D1NoTitleDim);
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.layout_achievements);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //  blur.setVisibility(View.INVISIBLE);
                        dialog.dismiss();
                    }
                });
            }
        });

        mImgSkills.setOnClickListener(new View.OnClickListener() {
            public Dialog dialog = new Dialog(ProfileActvity.this,R.style.Theme_D1NoTitleDim);
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.layout_skills);
                dialog.show();
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        //  blur.setVisibility(View.INVISIBLE);
                        dialog.dismiss();
                    }
                });
            }
        });


    }


    public void init(){
        mImgAchieve = (ImageView)findViewById(R.id.imgvProfileAchievementBtn);
        mImgInventory = (ImageView) findViewById(R.id.imgvProfileInventoryBtn);
        mImgSkills = (ImageView) findViewById(R.id.imgvProfileSkillsBtn);
        mImgShop = (ImageView) findViewById(R.id.imgvProfileShopBtn);
    }

}
