package com.example.dobit.rplife;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dobit.rplife.Home.CircleCountDownView;


public class FocusActivity extends Activity implements View.OnClickListener {

    protected EditText etTime;
    protected CircleCountDownView countDownView;
    protected ImageView startTimerBt, cancelTimerBt;
    private TextView mTvMinutes;
    private TextView mTvSeconds;
    private TextView mTvTimer;
    int progress;
    int endTime;
    CountDownTimer countDownTimer;

    int count = 0;
    int seconds =59;
    int minutes;
    int hours=0;
    int time;

    Thread t;
    boolean stop = false;
    private volatile boolean isRunning = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // etTime = (EditText) findViewById(R.id.et_total_time);
        countDownView = (CircleCountDownView) findViewById(R.id.circle_count_down_view);
        startTimerBt = (ImageView) findViewById(R.id.startTimer);
        cancelTimerBt = (ImageView) findViewById(R.id.cancelTimer);
        mTvMinutes = (TextView) findViewById(R.id.tvMinutes);
        mTvSeconds = (TextView) findViewById(R.id.tvSec);
        // set click listeners
        startTimerBt.setOnClickListener(this);
        cancelTimerBt.setOnClickListener(this);


    }

    protected void startCountDown(final View view) {

        //String timeInterval = etTime.getText().toString();



        //etTime.getText().clear();
        view.setVisibility(View.GONE); // hide button
       // show progress view
        countDownView.setVisibility(View.VISIBLE);
        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button

        progress = 1;
        endTime = 25; // up to finish time
        minutes = endTime-1;
        time= endTime*60;

        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownView.setProgress(progress, time );
                progress = progress + 1;

                if(seconds >= 0)
                {

                    mTvMinutes.setText(minutes+"");
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

                if(count == 60 && minutes != 0)
                {
                    minutes--;
                    count = 0;
                    mTvMinutes.setText(minutes+"");
                    seconds = 59;
                }

            }

            @Override
            public void onFinish() {
                countDownView.setProgress(progress, time);
                view.setVisibility(View.VISIBLE);
                cancelTimerBt.setVisibility(View.GONE);
                minutes=0;
                seconds=59;
            }
        };
        countDownTimer.start(); // start timer

        // hide softkeyboard
        View currentFocus = this.getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

//    protected void start(final View view){
//
//        view.setVisibility(View.GONE); // hide button
//        countDownView.setVisibility(View.VISIBLE); // show progress view
//        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button
//
//        progress = 1;
//        endTime = 25; // up to finish time
//        minutes = endTime-1;
//        time= endTime*60;
//        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
//
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                countDownView.setProgress(progress, time);
//                progress = progress + 1;
//
//
//            }
//
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
//        // hide softkeyboard
//        View currentFocus = this.getCurrentFocus();
//        if (currentFocus != null) {
//            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
//        }
//    }


    public void stopCountDown(View view) {

        countDownView.setProgress(time,time);
        countDownTimer.cancel();
        seconds=59;
        countDownView.setVisibility(View.INVISIBLE);
        cancelTimerBt.setVisibility(View.GONE);
        startTimerBt.setVisibility(View.VISIBLE);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startTimer:
                startCountDown(view);
                break;
            case R.id.cancelTimer:
                stopCountDown(view);
                break;
        }
    }





}
