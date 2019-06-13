package com.example.diit24.mvp.autorization;

import com.example.diit24.data.global.DataManager;
import com.example.diit24.data.global.models.User;
import com.example.diit24.mvp.global.MvpPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.diit24.App.user;

public class AutorizationPresenter extends MvpPresenter<AutorizationView> {
    private DataManager dataManager;
    private Call<User> loginCall;


    public AutorizationPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    public void autorization(String login, String password) {
        // Выполняет авторизацию
        loginCall = dataManager.login(login, password);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                user=response.body();

                if (response.body()==null) getView().showerror();
                else { getView().showmassage();
              getView().inteny();}
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            getView().showerror();
            }
        });
    }
}

