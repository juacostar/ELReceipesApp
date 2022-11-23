package com.example.elreceipesapp.data.model

import com.google.gson.annotations.SerializedName

data class Receipes (

    @SerializedName("recipes")
    val recipes: List<Receipe>
)