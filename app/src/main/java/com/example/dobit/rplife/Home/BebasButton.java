package com.example.dobit.rplife.Home;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by dobit on 12/3/2016.
 */

public class BebasButton extends Button {
    public BebasButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeue.ttf"));
    }
}
