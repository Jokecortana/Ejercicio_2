package com.example.ejercicio_2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio_2.databinding.Ex2ElementBinding
import com.example.ejercicio_2.model.Personaje

class PersonajeAdapter(private var context: Context, private var personajes: ArrayList<Personaje>, private val clickListener: (Personaje)->Unit) :
    RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {

    class ViewHolder(val binding: Ex2ElementBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivThumbnail = binding.ivThumbnail
        val tvTitle = binding.tvTitle
        val tvDeveloper = binding.tvDeveloper

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = Ex2ElementBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = personajes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.tvTitle.text = personaje.name
        holder.tvDeveloper.text = personaje.actor


        Glide.with(context)
            .load(personaje.image)
            .into(holder.ivThumbnail)

        holder.itemView.setOnClickListener {
            clickListener(personajes[position])
        }
    }
}