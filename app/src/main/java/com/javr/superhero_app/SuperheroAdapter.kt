package com.javr.superhero_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.javr.superhero_app.databinding.ItemSuperheroBinding

class SuperheroAdapter(
    private var lstSuperhero: List<Superhero> = emptyList()
//    private val onSuperheroSelected: () -> Unit
) : RecyclerView.Adapter<SuperheroViewHolder>() {
    fun updateList(lstSuperhero: List<Superhero>){
        this.lstSuperhero = lstSuperhero
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(lstSuperhero[position])
    }

    override fun getItemCount(): Int = lstSuperhero.size
}

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superhero: Superhero) {
        binding.tvNameSuperhero.text = superhero.name
    }
}