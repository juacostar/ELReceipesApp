package com.example.elreceipesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elreceipesapp.R
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.data.model.ReceipeDetailV2
import com.example.elreceipesapp.viewHolder.ReceipesSimpleViewHolder

class ReceipesSimpleAdapter (private val recipeSimpleList: List<ReceipeDetailV2>,
    private val onClickListener: (ReceipeDetailV2) -> Unit
) : RecyclerView.Adapter<ReceipesSimpleViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipesSimpleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReceipesSimpleViewHolder(
            layoutInflater.inflate(
                R.layout.item_simple_receipe,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReceipesSimpleViewHolder, position: Int) {
        val item = recipeSimpleList[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = recipeSimpleList.size

}