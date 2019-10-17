package com.xheghun.ignitetechtest._interface

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @POST("login/{email}{password}")
    fun login(@Path("email") email: String,@Path("password") password: String): Call<String>
}