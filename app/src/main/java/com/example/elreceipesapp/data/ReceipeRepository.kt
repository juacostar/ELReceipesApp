package com.example.elreceipesapp.data

import androidx.appcompat.app.AppCompatActivity
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeV2
import com.example.elreceipesapp.data.model.Receipes
import com.example.elreceipesapp.data.network.ReceipesService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class ReceipeRepository @Inject constructor() {

    private val receipesService = ReceipesService()

    suspend fun findAll(): Receipes {
        return receipesService.getRecipes()
    }

    suspend fun findbyId(id: Int): Receipe {
        return receipesService.getDetailReceipe(id)

    }

    suspend fun findByFilter(query: String): ReceipeV2 {
        return receipesService.getRecipeByFilter(query)
    }

}