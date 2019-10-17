package com.xheghun.ignitetechtest.model

import com.google.gson.annotations.SerializedName

data class LoginParam(
    @SerializedName("emailAddr")
    val email: String,
    @SerializedName("password")
    val password: String
)