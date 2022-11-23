package com.example.elreceipesapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.example.elreceipesapp.data.model.Ingredient
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.databinding.ActivityMainBinding
import com.example.elreceipesapp.databinding.ActivityReceipeDetailBinding

class ReceipeDetail : AppCompatActivity() {

    private lateinit var binding: ActivityReceipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", -1)
        val aggregateLikes = intent.getIntExtra("aggregateLikes", -1)
        val image = intent.getStringExtra("image")
        val readyInMinutes = intent.getIntExtra("readyInMinutes", -1)
        val servings = intent.getIntExtra("servings", -1)
        val summary = intent.getStringExtra("summary")
        val title = intent.getStringExtra("title")
        val vegetarian = intent.getBooleanExtra("vegetarian", false)


        var recipe = Receipe(id = id, aggregateLikes = aggregateLikes, extendedIngredients = ArrayList<Ingredient>(),
            image = image!!,
            readyInMinutes = readyInMinutes,
            servings = servings,
            summary = summary!!,
            title = title!!,
            vegetarian = vegetarian
        )

        completeRecipe(recipe)


    }


    @SuppressLint("SetTextI18n")
    private fun completeRecipe(completeRecipe: Receipe?) {


        val vegetarian: String
        val result = completeRecipe?.summary
        val ingredients = mutableListOf<String>()

        if (completeRecipe?.vegetarian == true) {
            vegetarian = "Vegetarian"
        } else {
            vegetarian = "Non Vegetarian"
        }

        Glide.with(binding.ivRecipe.context).load(completeRecipe?.image).into(binding.ivRecipe)
        binding.tvTitle.text = completeRecipe?.title
        binding.tvLikes.text = "${completeRecipe?.aggregateLikes} likes"
        binding.tvServings.text = "${completeRecipe?.servings} Servings"
        binding.tvTime.text = "${completeRecipe?.readyInMinutes} minutes"
        binding.tvVegetarian.text = "$vegetarian"
        binding.tvSummary.text =
            result?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY) }

//        for (i in completeRecipe?.extendedIngredients!!) {
//
//            val name = i.name
//
//            var firstLtr = name.substring(0, 1)
//            val restLtrs = name.substring(1, name.length)
//
//            firstLtr = firstLtr.uppercase()
//            var ingredientName = firstLtr + restLtrs
//
//            ingredients.add("*  $ingredientName -- ${i.original}")
//
//        }

//        val separator = "\n\n"
//
//        val ingredientsStr = ingredients.joinToString(separator)
//
//        binding.tvIngredients.text = ingredientsStr

    }



}


