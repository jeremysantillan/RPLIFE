package com.example.dobit.rplife.Home;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Basilan on 11/30/2016.
 */

public class Contents2 implements Parcelable {
    public String text;
    public String minutesOrHours;
    public String dueDate;
    public String startTime;
    public String endTime;
    public String task;
    public int sidebar;
    public int sidebar2;
    public int difficulty;
    public int stamina;
    public Contents2() {

    }


    public Contents2(Parcel input){
        text = input.readString();
        minutesOrHours = input.readString();
        dueDate = input.readString();
        startTime = input.readString();
        endTime = input.readString();
        task = input.readString();
        sidebar = input.readInt();
        sidebar2 = input.readInt();
        difficulty = input.readInt();
        stamina = input.readInt();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMinutesOrHours() {
        return minutesOrHours;
    }

    public void setMinutesOrHours(String minutesOrHours) {
        this.minutesOrHours = minutesOrHours;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getSidebar() {
        return sidebar;
    }

    public void setSidebar(int sidebar) {
        this.sidebar = sidebar;
    }

    public int getSidebar2() {
        return sidebar2;
    }

    public void setSidebar2(int sidebar2) {
        this.sidebar2 = sidebar2;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeString(minutesOrHours);
        parcel.writeString(dueDate);
        parcel.writeString(startTime);
        parcel.writeString(endTime);
        parcel.writeString(task);
        parcel.writeInt(sidebar);
        parcel.writeInt(sidebar2);
        parcel.writeInt(difficulty);
        parcel.writeInt(stamina);
    }

    public static final Parcelable.Creator<Contents2> CREATOR
            = new Parcelable.Creator<Contents2>() {
        public Contents2 createFromParcel(Parcel in) {
            return new Contents2(in);
        }

        public Contents2[] newArray(int size) {
            return new Contents2[size];
        }
    };
}
