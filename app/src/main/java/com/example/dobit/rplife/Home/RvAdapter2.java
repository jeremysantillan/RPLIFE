package com.example.dobit.rplife.Home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dobit.rplife.FocusActivity;
import com.example.dobit.rplife.R;
import com.github.mmin18.widget.RealtimeBlurView;


import java.util.ArrayList;

/**
 * Created by Basilan on 11/30/2016.
 */

public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.MyViewHolder2> {
    int[] check = new int[20];
    int temp;
    MediaPlayer focusSound;
    Context context;
    ArrayList<Contents2> data;
    LayoutInflater inflater;
//    ImageView sidebar;

    //focus  declarations
    protected CircleCountDownView countDownView;
    protected ImageView startTimerBt, cancelTimerBt;
    private TextView mTvMinutes;
    private TextView mTvSeconds;
    private TextView mTvTimer;
    int progress;
    double endTime;
    CountDownTimer countDownTimer;


    int count = 0;
    int seconds =9;
    int minutes;
    int hours=0;
    int time;
    Dialog dialog;


    ////////////////////////////////////////////////////////

    //blur
    com.github.mmin18.widget.RealtimeBlurView blurView;



    public RvAdapter2(Context context, ArrayList<Contents2> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int position) {


        View view = inflater.inflate(R.layout.temp, parent, false);

        MyViewHolder2 holder = new MyViewHolder2(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder2 myViewHolder2, final int position) {
        myViewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check[temp] == 1){
                    focusSound.start();
                    myViewHolder2.sidebar.setImageResource(data.get(position).sidebar2);
//                   myViewHolder2.sidebar.setImageDrawable(R.drawable.orange_sidebar);
//                    Intent intent = new Intent(context, FocusActivity.class);
//                    context.startActivity(intent);
                }
                focusSound = MediaPlayer.create(context, R.raw.stay_focused);
              //  blurView.setVisibility(View.VISIBLE);
                dialog = new Dialog(context,R.style.Theme_D1NoTitleDim);
                dialog.getWindow().setLayout(1300,2000);
//                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                dialog.setContentView(R.layout.activity_main);
                countDownView = (CircleCountDownView)dialog.findViewById(R.id.circle_count_down_view);
                startTimerBt  = (ImageView) dialog.findViewById(R.id.startTimer);
                cancelTimerBt = (ImageView) dialog.findViewById(R.id.cancelTimer);
                mTvMinutes = (TextView)dialog.findViewById(R.id.tvMinutes);
                mTvSeconds = (TextView)dialog.findViewById(R.id.tvSec);
                mTvMinutes.setText("00");
                dialog.show();

//                progress = 0;
//                endTime = 25; // up to finish time
//                minutes = endTime;
//                time= endTime;
                progress = 0;
                time = 9;

                countDownView.setVisibility(View.VISIBLE);
                countDownView.setProgress(progress,time);

                startTimerBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        //String timeInterval = etTime.getText().toString();
                        //dialog.setContentView(R.layout.layout_count_down_view);

                        //etTime.getText().clear();
                        view.setVisibility(View.GONE); // hide button
                        // show progress view
                        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button

//                        progress = 1;
//                        endTime = 25; // up to finish time
//                        minutes = endTime-1;
//                        time= endTime*60;
                        mTvMinutes.setText("00");
                        progress = 1;
                        endTime =  0.0833333;
                        minutes = 0;
                        time = 10;



                        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                               countDownView.setProgress(progress, time );
                                progress = progress + 1;
                                mTvMinutes.setText("00");
                                if(seconds > 0)
                                {

                                    //mTvMinutes.setText(minutes+"");
                                    if(seconds <10){
                                        mTvSeconds.setText("0"+seconds);
                                        seconds--;
                                        count++;
                                    }else{
                                        mTvSeconds.setText(seconds+"");
                                        seconds--;
                                        count++;
                                    }

                                }

//                                if(count == 60 && minutes != 0)
//                                {
//                                    minutes--;
//                                    count = 0;
//                                    mTvMinutes.setText(minutes+"");
//                                    seconds = 59;
//                                }

                            }

                            @Override
                            public void onFinish() {
                                countDownView.setProgress(progress, time);
                                view.setVisibility(View.VISIBLE);
                                cancelTimerBt.setVisibility(View.GONE);
//                                minutes=0;
//                                seconds=59;
                                minutes = 0;
                                seconds = 9;
                                time = 10;
                                progress =1;
                                mTvMinutes.setText("00");
                                mTvSeconds.setText("00");
                            }
                        };
                        countDownTimer.start(); // start timer

//        // hide softkeyboard
//        View currentFocus = this.getCurrentFocus();
//        if (currentFocus != null) {
//            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
//        }
                    }
                });

                cancelTimerBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        countDownView.setProgress(time,time);
                        countDownTimer.cancel();
                        //seconds=59;
                        seconds=9;
                        time = 10;
                        progress=1;
                        countDownView.setVisibility(View.INVISIBLE);
                        cancelTimerBt.setVisibility(View.GONE);
                        startTimerBt.setVisibility(View.VISIBLE);
                        dialog.dismiss();

                    }
                });

                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                        countDownView.setProgress(time,time);
                        countDownTimer.cancel();
                       // seconds=59;
                        seconds=9;
                        time = 9;
                        progress=0;
                        countDownView.setVisibility(View.INVISIBLE);
                        cancelTimerBt.setVisibility(View.GONE);
                        startTimerBt.setVisibility(View.VISIBLE);
                    }
                });

                check[position] = 1;
                temp = position;
                Log.d("Gwapo3", temp+"");
                myViewHolder2.sidebar.setImageResource(data.get(position).sidebar);
            }
        });

        myViewHolder2.something.setText(data.get(position).text);
        myViewHolder2.minutesOrHours.setText(data.get(position).minutesOrHours);
        myViewHolder2.dueDate.setText(data.get(position).dueDate);
        myViewHolder2.startTime.setText(data.get(position).startTime);
        myViewHolder2.endTime.setText(data.get(position).endTime);
        myViewHolder2.task.setText(data.get(position).task);
        myViewHolder2.difficulty.setImageResource(data.get(position).difficulty);
//        myViewHolder2.stamina.setImageResource(data.get(position).stamina);
//        myViewHolder2.image.setImageResource(data.get(position).image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.startTimer:
//                startCountDown(v);
//                break;
//            case R.id.cancelTimer:
//                stopCountDown(v);
//                break;
//        }
//    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView something;
        TextView minutesOrHours;
        TextView dueDate;
        TextView startTime;
        TextView endTime;
        TextView task;
        ImageView difficulty;
        ImageView stamina;
        ImageView sidebar;
        ImageView sidebar2;
//        ImageView image;

        public MyViewHolder2(View itemView) {
            super(itemView);
            sidebar = (ImageView) itemView.findViewById(R.id.iv2);
//            sidebar2 = (ImageView) itemView.findViewById(R.id.ivSide);
            something = (TextView) itemView.findViewById(R.id.tv1);
            minutesOrHours = (TextView) itemView.findViewById(R.id.tvMinutesOrHours);
            dueDate = (TextView) itemView.findViewById(R.id.tvDueDate);
            startTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            endTime = (TextView) itemView.findViewById(R.id.tvStopTime);
            task = (TextView) itemView.findViewById(R.id.tvTask);
            difficulty = (ImageView) itemView.findViewById(R.id.ivDifficulty);
            stamina = (ImageView) itemView.findViewById(R.id.ivStamina);
//            image = (ImageView) itemView.findViewById(R.id.iv1);

        }
    }

    public void stopCountDown(View view) {

        countDownView.setProgress(time,time);
        countDownTimer.cancel();
        seconds=59;
        countDownView.setVisibility(View.INVISIBLE);
        cancelTimerBt.setVisibility(View.GONE);
        startTimerBt.setVisibility(View.VISIBLE);
    }

//    protected void startCountDown(final View view) {
//
//        //String timeInterval = etTime.getText().toString();
//
//
//        //etTime.getText().clear();
//        view.setVisibility(View.GONE); // hide button
//        // show progress view
//        countDownView.setVisibility(View.VISIBLE);
//        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button
//
//        progress = 1;
//        endTime = 25; // up to finish time
//        minutes = endTime-1;
//        time= endTime*60;
//
//        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                countDownView.setProgress(progress, time );
//                progress = progress + 1;
//
//                if(seconds >= 0)
//                {
//
//                    mTvMinutes.setText(minutes+"");
//                    if(seconds <10){
//                        mTvSeconds.setText("0"+seconds);
//                        seconds--;
//                        count++;
//                    }else{
//                        mTvSeconds.setText(seconds+"");
//                        seconds--;
//                        count++;
//                    }
//
//                }
//
//                if(count == 60 && minutes != 0)
//                {
//                    minutes--;
//                    count = 0;
//                    mTvMinutes.setText(minutes+"");
//                    seconds = 59;
//                }
//
//            }
//
//            @Override
//            public void onFinish() {
//                countDownView.setProgress(progress, time);
//                view.setVisibility(View.VISIBLE);
//                cancelTimerBt.setVisibility(View.GONE);
//                minutes=0;
//                seconds=59;
//            }
//        };
//        countDownTimer.start(); // start timer
//
////        // hide softkeyboard
////        View currentFocus = this.getCurrentFocus();
////        if (currentFocus != null) {
////            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
////            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
////        }
//    }



}
