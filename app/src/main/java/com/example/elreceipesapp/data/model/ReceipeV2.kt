package com.example.elreceipesapp.data.model

import com.google.gson.annotations.SerializedName

data class ReceipeV2  (

    @SerializedName("results")
    val results: List<ReceipeDetailV2>

)