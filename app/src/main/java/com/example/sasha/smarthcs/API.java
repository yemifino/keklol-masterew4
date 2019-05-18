package com.example.sasha.smarthcs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @POST("/check_password")
    Call<Reply> login(@Body Login user);

    @POST("/GSV")
    Call<GSV> getResources(@Body POST_GSV GSV );


    @POST("/get_data/{type}")
    Call<ResursePOL> getFullResources(@Body PostData ResursePOL ,@Query("type") String type);



}
