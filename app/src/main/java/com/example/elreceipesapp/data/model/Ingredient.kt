package com.example.elreceipesapp.data.model

import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.SerializedName

@VersionedParcelize
data class Ingredient(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("originalName")
    val originalName: String,
)
