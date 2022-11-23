package com.example.elreceipesapp.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.elreceipesapp.data.local.dao.RecipeDao
import com.example.elreceipesapp.data.local.entity.ReceipeEntity

//@Database(entities = [ReceipeEntity::class], version = 1, exportSchema = false)
//@TypeConverters(TypeConverter::class)
//abstract class Database: RoomDatabase() {
//
//
//    companion object {
//        fun get(application: Application): com.example.elreceipesapp.data.local.Database {
//            return Room.databaseBuilder(application, com.example.elreceipesapp.data.local.Database::class.java, "recipe_database")
//                .build()
//        }
//    }
//
//    abstract fun getRecipeDao(): RecipeDao
//
//}