package com.example.elreceipesapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.viewModels
import com.example.elreceipesapp.adapter.ReceipesSimpleAdapter
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeDetailV2
import com.example.elreceipesapp.data.model.ReceipeV2
import com.example.elreceipesapp.data.model.Receipes
import com.example.elreceipesapp.databinding.ActivitySearchBinding
import com.example.elreceipesapp.viewmodel.ReceipesViewModel
import com.example.elreceipesapp.viewmodel.SearchReceipesViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    lateinit var receipesFullList: Receipes
    private lateinit var simpleAdapter: ReceipesSimpleAdapter
    private var receipesSimpleList = mutableListOf<ReceipeDetailV2>()
    private val searchRecipesViewModel : SearchReceipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var button = binding.SearchButton
//
//        button.setOnClickListener(){
//
//        }


        searchRecipesViewModel.onCreate()


//        searchRecipesViewModel.isLoading.observe(this) {
////            receipesSimpleList.clear()
////            receipesSimpleList.addAll(it.results)
////
////            simpleAdapter = ReceipesSimpleAdapter(receipesSimpleList){
////                onItemSelected(it)
////            }
////
//
//        }
//
        searchRecipesViewModel.findByFilter("")

    }


    private fun onItemSelected(it: ReceipeDetailV2) {

//        val intent = Intent(this, ReceipeDetail::class.java).apply {
//            putExtra("id", it.id)
//            putExtra("image", it.image)
//            putExtra("title", it.title)
//
//        }
//
//        startActivity(intent)
    }



    fun search(query: String?){
        if (!query.isNullOrEmpty()) {
            searchRecipesViewModel.findByFilter(query)
        }
    }

     fun onQueryTextSubmit(query: String?): Boolean {

        if (!query.isNullOrEmpty()) {
            searchRecipesViewModel.findByFilter(query)
        }

        val context = binding.receipesList.context

        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.root.windowToken, 0)

        return true

    }
}