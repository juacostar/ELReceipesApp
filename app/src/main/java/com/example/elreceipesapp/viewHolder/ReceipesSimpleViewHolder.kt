package com.example.elreceipesapp.viewHolder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeDetailV2
import com.example.elreceipesapp.databinding.ItemSimpleReceipeBinding

class ReceipesSimpleViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSimpleReceipeBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(recipe: ReceipeDetailV2, onClickListener: (ReceipeDetailV2) -> Unit) {

        binding.tvTitle.text = recipe.title
        Glide.with(binding.ivRecipeSimple.context).load(recipe.image).into(binding.ivRecipeSimple)
        binding.tvInformation.setOnClickListener { onClickListener(recipe) }
    }
}