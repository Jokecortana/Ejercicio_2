package com.example.ejercicio_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ejercicio_2.R
import com.example.ejercicio_2.databinding.ActivityDetailsBinding
import com.example.ejercicio_2.model.PersonajeDetail
import com.example.ejercicio_2.network.PersonajeApi
import com.example.ejercicio_2.network.RetrofitService
import com.example.ejercicio_2.utils.Constants
import retrofit2.Call
import retrofit2.Response

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val id = bundle?.getString("id", "")
        val call = RetrofitService.getRetrofit().create(PersonajeApi::class.java).getPersonDetail(id)

        call.enqueue(object : retrofit2.Callback<ArrayList<PersonajeDetail>> {
            override fun onResponse(
                call: Call<ArrayList<PersonajeDetail>>,
                response: Response<ArrayList<PersonajeDetail>>
            ) {
                binding.pbConexion.visibility = View.GONE

                val personajeDetailList = response.body()
                if (personajeDetailList != null && personajeDetailList.isNotEmpty()) {
                    val personajeDetail = personajeDetailList[0]

                    binding.tvTitle.text = personajeDetail.name
                    binding.tvLongDesc1.text = personajeDetail.species
                    binding.tvLongDesc2.text = personajeDetail.house
                    binding.tvLongDesc3.text = personajeDetail.gender
                    binding.tvLongDesc4.text = personajeDetail.dateOfBirth
                    binding.tvLongDesc5.text = personajeDetail.ancestry
                    binding.tvLongDesc6.text = personajeDetail.patronus

                    Glide.with(this@Details)
                        .load(personajeDetail.image)
                        .into(binding.ivImage)
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonajeDetail>>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@Details, "No hay conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}