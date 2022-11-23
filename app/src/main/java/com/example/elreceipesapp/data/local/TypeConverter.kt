package com.example.elreceipesapp.data.local

import androidx.room.TypeConverter
import com.example.elreceipesapp.data.model.Ingredient
import com.example.elreceipesapp.data.model.Receipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: Receipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): Receipe {
        val listType = object : TypeToken<Receipe>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun resultToString(result: List<Ingredient>): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data: String): List<Ingredient> {
        val listType = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(data, listType)
    }
}