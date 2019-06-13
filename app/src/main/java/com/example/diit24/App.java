package com.example.diit24;


import android.app.Application;

import com.arellomobile.mvp.MvpFacade;
import com.example.diit24.data.global.DataManager;
import com.example.diit24.data.global.models.User;
import com.example.diit24.data.remote.DiitApi;
import com.example.diit24.di.global.AppComponent;
import com.example.diit24.di.global.DaggerAppComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.diit24.data.global.Constants.BASE_URL;

public class App extends Application {

    public static DataManager dataManager;
    public static User user;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        MvpFacade.init();
        appComponent = buildAppComponent();
        getApi();

    }

    public static DiitApi getApi() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        DiitApi diitApi = retrofit.create(DiitApi.class);

        dataManager = new DataManager(diitApi);

        return diitApi;
    }

    private AppComponent buildAppComponent(){
        return DaggerAppComponent.builder()
                .context(this)
                .build();
    }


}
