package com.example.dobit.rplife.Home;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class QuestData {
    public static ArrayList<QuestModel> getQuestData(){
        ArrayList<QuestModel> questModel = new ArrayList<>();
        int[] quests = {R.drawable.quests_1, R.drawable.quests_2, R.drawable.quests_3, R.drawable.quests_4};

        for(int i = 0; i < 4; i++){
            QuestModel current = new QuestModel();
            current.imageQuest = quests[i];
            questModel.add(current);
        }
        return questModel;
    }
}
