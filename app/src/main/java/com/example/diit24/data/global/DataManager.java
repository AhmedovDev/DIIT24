package com.example.diit24.data.global;

import com.example.diit24.data.global.models.User;
import com.example.diit24.data.remote.DiitApi;

import retrofit2.Call;

public class DataManager  {

    private DiitApi diitApi;

    public DataManager (DiitApi diitApi) {
        this.diitApi = diitApi;
    }


    public Call<User> login(String login, String password) {
        return diitApi.login ( login, password);
    }
}
