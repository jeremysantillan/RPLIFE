package com.example.dobit.rplife.Home;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class ChatData {
    public static ArrayList<ChatModel> getChatData(){
        ArrayList<ChatModel> chatModel = new ArrayList<>();
        int[] charFaces = {R.drawable.char_4, R.drawable.char_1, R.drawable.char_3,
        R.drawable.char_2, R.drawable.char_1};
        String[] messages = {"How are you guys?", "I am fine", "Me too", "Guys, lets do a quest",
        "Later"};
        int[] cb = {R.drawable.lchat_1, R.drawable.rchat_2, R.drawable.lchat_1, R.drawable.lchat_1, R.drawable.rchat_2};


        for(int i = 0; i < 5; i++){
            ChatModel current = new ChatModel();
            current.image = charFaces[i];
            current.message = messages[i];
            current.imageBubble = cb[i];
            chatModel.add(current);
        }
        return chatModel;
    }
}
