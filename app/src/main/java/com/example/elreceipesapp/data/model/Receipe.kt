package com.example.elreceipesapp.data.model

import com.google.gson.annotations.SerializedName

data class Receipe (

    @SerializedName("id")
    val id: Int,
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<Ingredient>,
    @SerializedName("image")
    val image: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vegetarian")
    val vegetarian: Boolean,

    )