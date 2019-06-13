package com.example.diit24.mvp.tasks;

import com.example.diit24.App;
import com.example.diit24.data.global.DataManager;
import com.example.diit24.mvp.global.MvpPresenter;

import java.util.Collections;

public class TaskPresenter extends MvpPresenter<TaskView> {
    private DataManager dataManager;


    public TaskPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    public void getUsersShow() {
getView().showUsers(Collections.singletonList(App.user));

    }

}
