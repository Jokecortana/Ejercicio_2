package com.example.ejercicio_2.view.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio_2.R
import com.example.ejercicio_2.databinding.ActivityMainBinding
import com.example.ejercicio_2.model.Personaje
import com.example.ejercicio_2.network.PersonajeApi
import com.example.ejercicio_2.network.RetrofitService
import com.example.ejercicio_2.utils.Constants
import com.example.ejercicio_2.view.adapters.PersonajeAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitService.getRetrofit().create(PersonajeApi::class.java).getPerson("api/characters/students/")

        call.enqueue(object : retrofit2.Callback<ArrayList<Personaje>> {
            override fun onResponse(
                call: Call<ArrayList<Personaje>>,
                response: Response<ArrayList<Personaje>>
            ) {
                binding.pbConexion.visibility = View.GONE

                Log.d(Constants.LOGTAG, "Respuesta del servidor: ${response.body().toString()}")

                binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvMenu.adapter = PersonajeAdapter(this@MainActivity, response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Personaje>>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}