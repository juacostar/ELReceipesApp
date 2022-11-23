package com.example.elreceipesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elreceipesapp.adapter.ReceipesAdapter
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.Receipes
import com.example.elreceipesapp.databinding.ActivityMainBinding
import com.example.elreceipesapp.databinding.ActivityReceipeDetailBinding
import com.example.elreceipesapp.viewmodel.ReceipesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ReceipesAdapter

    private val receipesViewModel: ReceipesViewModel by viewModels()
    private var recipesList = mutableListOf<Receipe>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var button = binding.searchButton

        button.setOnClickListener(){
            passToSearch()
        }

        if(recipesList.isEmpty()){
            receipesViewModel.onCreate()
        }


        receipesViewModel.receipes.observe(this) {
            if (recipesList.isEmpty()) {
                recipesList.clear()
                recipesList.addAll(it.recipes)

                adapter = ReceipesAdapter(recipesList) {
                    onItemSelected(it)
                }

                binding.receipesList.layoutManager = LinearLayoutManager(binding.receipesList.context)
                binding.receipesList.adapter = adapter
            }
        }
    }

    private fun onItemSelected(it: Receipe) {

        val intent = Intent(this, ReceipeDetail::class.java).apply {
            putExtra("id", it.id)
            putExtra("aggregateLikes", it.aggregateLikes)
            putExtra("image", it.image)
            putExtra("readyInMinutes", it.readyInMinutes)
            putExtra("servings", it.servings)
            putExtra("summary", it.summary)
            putExtra("title", it.title)
            putExtra("vegetarian", it.vegetarian)

        }

        startActivity(intent)
    }

    private fun passToSearch() {

        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)

    }
}