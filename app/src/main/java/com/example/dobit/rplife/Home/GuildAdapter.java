package com.example.dobit.rplife.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class GuildAdapter extends RecyclerView.Adapter<GuildAdapter.MyGuildHolder> {
    Context context;
    ArrayList<GuildModel> data;
    LayoutInflater inflater;

    public GuildAdapter(Context context, ArrayList<GuildModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyGuildHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.guild_row, parent, false);
        MyGuildHolder holder = new MyGuildHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyGuildHolder holder, int position) {
        holder.guildImage.setImageResource(data.get(position).imageGuild);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyGuildHolder extends RecyclerView.ViewHolder{
        ImageView guildImage;

        public MyGuildHolder(View itemView) {
            super(itemView);
            guildImage = (ImageView) itemView.findViewById(R.id.ivGuild);
        }
    }
}