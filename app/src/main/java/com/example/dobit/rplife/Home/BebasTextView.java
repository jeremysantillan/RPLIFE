package com.example.dobit.rplife.Home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.dobit.rplife.R;

public class BebasTextView extends TextView {

    public BebasTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeue.ttf"));
    }
}

