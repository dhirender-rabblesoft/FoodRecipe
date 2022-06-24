package com.app.foodrecipe.network


import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @Headers("Accept: application/json")
    @Multipart
    @POST
    fun updateUser(
        @Url url: String,
        @Header("Authorization") token: String,
        @Part fields: ArrayList<MultipartBody.Part>
    ): Call<ResponseBody>?
    @Headers("Accept: application/json")
    @Multipart
    @POST
    fun createRecipe(
        @Url url: String,
        @Header("Authorization") token: String,
        @Part fields: ArrayList<MultipartBody.Part>
    ): Call<ResponseBody>?

    @Headers("Accept: application/json")
    @POST
    fun contactus(@Url url: String,@Body jsonObject: JsonObject?):Call<ResponseBody>



}