package com.example.elreceipesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeDetailV2
import com.example.elreceipesapp.data.model.ReceipeV2
import com.example.elreceipesapp.data.model.Receipes
import com.example.elreceipesapp.domain.FindOneRecipeUseCase
import com.example.elreceipesapp.domain.FindReceipesByFilterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchReceipesViewModel @Inject constructor(
    private val findOneRecipeUseCase: FindOneRecipeUseCase,
//    private val findReceipesByFilterUseCase: FindReceipesByFilterUseCase
): ViewModel() {

    val recipeList = MutableLiveData<Receipes>()
    val recipeSimple = MutableLiveData<ReceipeV2>()
    val receipeSimple:LiveData<ReceipeV2> = recipeSimple

    val isLoading = MutableLiveData<Boolean>()
    val completeRecipe = MutableLiveData<Receipe>()


    fun onCreate(
    ){
        isLoading.postValue(false)
    }

    fun findByFilter(query: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
//            val result = findReceipesByFilterUseCase(query)
//            recipeSimple.postValue(result)
            isLoading.postValue(false)

        }
    }

    fun findById(id: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
//            val result = findOneRecipeUseCase(id)

//            if (result != null) {
//                completeRecipe.postValue(result!!)
//                isLoading.postValue(false)
//            }

        }
    }
}