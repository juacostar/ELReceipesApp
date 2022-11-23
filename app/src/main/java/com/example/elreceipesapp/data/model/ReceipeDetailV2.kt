package com.example.elreceipesapp.data.model

import com.google.gson.annotations.SerializedName

class ReceipeDetailV2 (

    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("title")
    val title: String,
)