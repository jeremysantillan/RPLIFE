package com.example.dobit.rplife.controller;

import com.example.dobit.rplife.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basilan on 11/27/2016.
 */

public class TaskController {
    private List<Task> mTask;

    public TaskController(){
        mTask = new ArrayList<>();
        mTask.add(new Task("Eat"));
        mTask.add(new Task("Drink"));
        mTask.add(new Task("Code"));
        mTask.add(new Task("Sleep"));
        mTask.add(new Task("Study"));
        mTask.add(new Task("Play Guitar"));
        mTask.add(new Task("Do Assignments"));
        mTask.add(new Task("Finish TLE Project"));
    }

    public List<Task> getTask(){
        return mTask;
    }
}
