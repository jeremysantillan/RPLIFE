package com.example.dobit.rplife.Home;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class GuildData {
    public static ArrayList<GuildModel> getGuildData(){
        ArrayList<GuildModel> GuildModel = new ArrayList<>();
        int[] guilds = {R.drawable.guild_1, R.drawable.guild_2, R.drawable.guild_3,
        R.drawable.guild_4, R.drawable.guild_5, R.drawable.guild_6, R.drawable.guild_7,
        R.drawable.guild_8};

        for(int i = 0; i < 8; i++){
            GuildModel current = new GuildModel();
            current.imageGuild = guilds[i];
            GuildModel.add(current);
        }
        return GuildModel;
    }
}
