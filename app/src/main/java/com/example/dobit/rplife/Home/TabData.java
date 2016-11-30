package com.example.dobit.rplife.Home;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by Basilan on 11/30/2016.
 */

public class TabData {
    public static ArrayList<TabContents> getTabData() {
        ArrayList<TabContents> tabContents = new ArrayList<>();

        String[] text = {"30", "60", "80"};
        String[] mOrH = {"minutes", "minutes", "minutes"};
        String[] every = {"MWF", "TTH", "MTWTHFS"};
        String[] startTime = {"1:00 PM", "2:00 PM", "3:00 PM"};
        String[] endTime = {"1:30 PM", "3:00 PM", "4:20 PM"};
        String[] task = {"Wash dishes", "Clean room", "Study Algebra"};
        int[] sidebar = {R.drawable.orange_sidebar, R.drawable.orange_sidebar, R.drawable.orange_sidebar};
        int[] sidebar2 = {R.drawable.green_card_sidebar, R.drawable.green_card_sidebar, R.drawable.green_card_sidebar};
        int[] difficulty = {R.drawable.green_difficulty_bar, R.drawable.yellow_difficulty_bar, R.drawable.red_difficulty_bar};
        int[] stamina = {R.drawable.staminabar3, R.drawable.staminabar2, R.drawable.staminabar1};

        for (int i = 0; i < 3; i++)
        {
            TabContents current = new TabContents();
            current.sidebar2 = sidebar2[i];
            current.sidebar = sidebar[i];
            current.text = text[i];
            current.minutesOrHours = mOrH[i];
            current.every = every[i];
            current.startTime = startTime[i];
            current.endTime = endTime[i];
            current.difficulty = difficulty[i];
            current.stamina = stamina[i];
            current.task = task[i];
            tabContents.add(current);
        }
        return tabContents;
    }
}
