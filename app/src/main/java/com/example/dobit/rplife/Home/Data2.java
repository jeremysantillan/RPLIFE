package com.example.dobit.rplife.Home;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by Basilan on 11/30/2016.
 */

public class Data2 {
    public static ArrayList<Contents2> getData2(){
        ArrayList<Contents2> contents2 = new ArrayList<>();
        String[] text = {"30", "40", "60"};
        String[] mOrH = {"minutes", "minutes", "minutes"};
        String[] dueDate = {"12/15/16", "12/16/16", "12/18/16"};
        String[] startTime = {"1:00 PM", "2:00 PM", "5:00 PM"};
        String[] endTime = {"1:30 PM", "2:40 PM", "6:00 PM"};
        String[] task = {"Eat pizza", "Buy present", "Meet with group"};
        int[] sidebar = {R.drawable.orange_sidebar, R.drawable.orange_sidebar, R.drawable.orange_sidebar};
        int[] sidebar2 = {R.drawable.green_card_sidebar, R.drawable.green_card_sidebar, R.drawable.green_card_sidebar};
        int[] difficulty = {R.drawable.green_difficulty_bar, R.drawable.yellow_difficulty_bar, R.drawable.red_difficulty_bar};
        int[] stamina = {R.drawable.staminabar3, R.drawable.staminabar2, R.drawable.staminabar1};

        for (int i = 0; i < 3; i++)
        {
            Contents2 current = new Contents2();
            current.sidebar2 = sidebar2[i];
            current.sidebar = sidebar[i];
            current.text = text[i];
            current.minutesOrHours = mOrH[i];
            current.dueDate = dueDate[i];
            current.startTime = startTime[i];
            current.endTime = endTime[i];
            current.difficulty = difficulty[i];
            current.stamina = stamina[i];
            current.task = task[i];
            contents2.add(current);
        }

        return contents2;
    }
}
