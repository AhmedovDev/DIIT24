package com.example.diit24.data.remote;

import com.example.diit24.data.global.models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DiitApi {

//    @FormUrlEncoded
    @POST("api.php")
    Call<User> login(
            @Query("email") String apiUserName,
            @Query("password") String apiUserPassword);

}
