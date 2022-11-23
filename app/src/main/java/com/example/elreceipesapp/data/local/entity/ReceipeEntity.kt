package com.example.elreceipesapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.elreceipesapp.data.RecipesConverter
import com.example.elreceipesapp.data.model.Ingredient

@Entity(tableName = "receipe")
data class ReceipeEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "aggregateLikes") val aggregateLikes: Int,
    @TypeConverters(RecipesConverter::class)
    val extendedIngredients: List<Ingredient>,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "readyInMinutes") val readyInMinutes: Int,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "summary") val summary: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "vegetarian") val vegetarian: Boolean,

    )