package com.example.elreceipesapp.data.network

import com.example.elreceipesapp.core.RetrofitHelper
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeV2
import com.example.elreceipesapp.data.model.Receipes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ReceipesService @Inject constructor(){

    private val retrofit = RetrofitHelper.getRetrofit()
    private val apiKey = "0354b5e62cc34249800d0b5e41c5b29a"

    suspend fun getRecipes(): Receipes {
        return withContext(Dispatchers.IO) {

            val queries: Map<String, String> = mapOf(
                "apiKey" to apiKey,
                "number" to "10"
            )

            val response = retrofit.create(ReceipesApiClient::class.java).findAll(queries)
            response.body()!!
        }

    }

    suspend fun getRecipeByFilter(query: String): ReceipeV2 {
        return withContext(Dispatchers.IO) {

            val queries: Map<String, String> = mapOf(
                "apiKey" to apiKey,
                "number" to "10",
                "query" to query
            )

            val response = retrofit.create(ReceipesApiClient::class.java).findByFilter(queries)
            response.body()!!
        }

    }

    suspend fun getDetailReceipe(id: Int): Receipe {
        return withContext(Dispatchers.IO) {

            val queries: Map<String, String> = mapOf(
                "apiKey" to apiKey,
            )

            val response =
                retrofit.create(ReceipesApiClient::class.java).findDetail(id, queries)
            response.body()!!
        }
    }

}