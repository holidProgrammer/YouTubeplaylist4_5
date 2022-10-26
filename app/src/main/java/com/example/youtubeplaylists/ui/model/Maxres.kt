package com.example.ytparser.model


import com.google.gson.annotations.SerializedName

data class Maxres(
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int
)