package com.example.elreceipesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elreceipesapp.R
import com.example.elreceipesapp.data.model.Receipe
import com.example.elreceipesapp.viewHolder.ReceipesViewHolder

class ReceipesAdapter (
    private val recipe: List<Receipe>,
    private val onClickListener: (Receipe) -> Unit
) : RecyclerView.Adapter<ReceipesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReceipesViewHolder(layoutInflater.inflate(R.layout.item_receipe, parent, false))
    }

    override fun onBindViewHolder(holder: ReceipesViewHolder, position: Int) {
        val item = recipe[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount(): Int = recipe.size
}