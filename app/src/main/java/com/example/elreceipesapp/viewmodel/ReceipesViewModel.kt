package com.example.elreceipesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.Receipes
import com.example.elreceipesapp.domain.FindOneRecipeUseCase
import com.example.elreceipesapp.domain.GetAllReceipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReceipesViewModel @Inject constructor(
    private val getAllReceipesUseCase: GetAllReceipesUseCase,
    private val findOneRecipeUseCase: FindOneRecipeUseCase
): ViewModel() {

    val receipes = MutableLiveData<Receipes>()
    val isLoading = MutableLiveData<Boolean>()
    val recipeDetail = MutableLiveData<Receipe>()

            fun onCreate(){
                viewModelScope.launch {
                    isLoading.postValue(true)
                    val result = getAllReceipesUseCase()

                    if(result != null){
                        receipes.postValue(result)
                        isLoading.postValue(false)
                    }
                }
            }


    fun searchRecipeById(id: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = findOneRecipeUseCase(id)

            if (result != null) {
                recipeDetail.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }



}