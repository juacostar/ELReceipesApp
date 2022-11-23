package com.example.elreceipesapp.data.local.dao

import androidx.room.*
import com.example.elreceipesapp.data.local.entity.ReceipeEntity

@Dao
interface RecipeDao {

    @Query("SELECT * FROM receipe")
    suspend fun getAllRecipesDB(): List<ReceipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(root: ReceipeEntity)

    @Query("SELECT * FROM receipe WHERE id = :id")
    suspend fun findByUd(id: Int): ReceipeEntity

    @Delete
    suspend fun delete(root: ReceipeEntity)
}