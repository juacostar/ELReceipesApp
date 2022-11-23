package com.example.elreceipesapp.domain

import com.example.elreceipesapp.data.ReceipeRepository
import com.example.elreceipesapp.data.model.Receipe
import javax.inject.Inject

class FindOneRecipeUseCase @Inject constructor(private val repository: ReceipeRepository){

    suspend operator fun invoke(id: Int): Receipe = repository.findbyId(id)

}