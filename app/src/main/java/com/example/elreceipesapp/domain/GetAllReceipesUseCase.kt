package com.example.elreceipesapp.domain

import com.example.elreceipesapp.data.ReceipeRepository
import com.example.elreceipesapp.data.model.Receipes
import javax.inject.Inject

class GetAllReceipesUseCase @Inject constructor(private val receipeRepository: ReceipeRepository) {

    suspend operator fun invoke(): Receipes = receipeRepository.findAll()
}