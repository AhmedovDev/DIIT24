package com.example.diit24.mvp.tasks;

import com.example.diit24.data.global.models.User;
import com.example.diit24.mvp.global.MvpView;

import java.util.List;

public interface TaskView extends MvpView {
    void showUsers(List<User> users);


    void showmasage();
}
