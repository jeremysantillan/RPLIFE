package com.example.dobit.rplife.model;

/**
 * Created by Basilan on 11/27/2016.
 */

public class Task {
    private String taskName;

    public Task(){

    }

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}