package com.example.elreceipesapp.viewHolder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.databinding.ItemReceipeBinding

class ReceipesViewHolder(view: View): RecyclerView.ViewHolder(view) {


    private val binding = ItemReceipeBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(recipe: Receipe, onClickListener: (Receipe) -> Unit) {

        val vegetarian: String

        if (recipe.vegetarian) {
            vegetarian = "Vegetarian"
        } else {
            vegetarian = "Non Vegetarian"
        }

        binding.tvTitle.text = recipe.title
        binding.tvLikes.text = "  ${recipe.aggregateLikes} likes"
        binding.tvServings.text = "  ${recipe.servings} Servings"
        binding.tvTime.text = "  Ready in ${recipe.readyInMinutes} minutes"
        binding.tvVegetarian.text = "  $vegetarian"
        Glide.with(binding.ivRecipe.context).load(recipe.image).into(binding.ivRecipe)
        binding.tvInformation.setOnClickListener { onClickListener(recipe) }
    }

}