package com.javr.superhero_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.javr.superhero_app.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroAdapter(
    private var lstSuperhero: List<Superhero> = emptyList(),
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {
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
        holder.bind(lstSuperhero[position], onItemSelected)
    }

    override fun getItemCount(): Int = lstSuperhero.size

    class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemSuperheroBinding.bind(view)

        fun bind(superhero: Superhero, onItemSelected: (String) -> Unit) {
            binding.tvNameSuperhero.text = superhero.name
            Picasso.get().load(superhero.superheroImage.url).into(binding.ivSuperhero)
            binding.root.setOnClickListener { onItemSelected(superhero.id) }
        }
    }
}