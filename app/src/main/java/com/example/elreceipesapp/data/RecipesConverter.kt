package com.example.elreceipesapp.data

import androidx.room.TypeConverter
import com.example.elreceipesapp.data.model.Ingredient
import com.example.elreceipesapp.data.model.IngredientList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesConverter {
    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: IngredientList): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): IngredientList {
        val listType = object : TypeToken<IngredientList>() {}.type
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