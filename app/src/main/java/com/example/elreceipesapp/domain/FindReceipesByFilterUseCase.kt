package com.example.elreceipesapp.domain

import com.example.elreceipesapp.data.ReceipeRepository
import com.example.elreceipesapp.data.model.ReceipeV2
import javax.inject.Inject

class FindReceipesByFilterUseCase @Inject constructor(private val receipesRepository: ReceipeRepository) {

    suspend operator fun invoke(query: String): ReceipeV2 =
        receipesRepository.findByFilter(query)

}