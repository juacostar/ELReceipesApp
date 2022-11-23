package com.example.elreceipesapp.data.network

import android.provider.DocumentsContract
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeV2
import com.example.elreceipesapp.data.model.Receipes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import javax.inject.Inject


interface ReceipesApiClient{


    @GET("/recipes/random")
    suspend fun findAll(
        @QueryMap queryKey: Map<String, String>
    ): Response<Receipes>

    @GET("/recipes/complexSearch")
    suspend fun findByFilter(
        @QueryMap queryKey: Map<String, String>
    ): Response<ReceipeV2>

    @GET("/recipes/{id}/information")
    suspend fun findDetail(
        @Path("id") id: Int,
        @QueryMap queryKey: Map<String, String>
    ): Response<Receipe>

}