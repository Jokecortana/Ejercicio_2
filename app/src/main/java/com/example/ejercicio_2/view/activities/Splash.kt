package com.example.ejercicio_2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio_2.R
import com.example.ejercicio_2.databinding.ActivitySplashBinding
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        thread {

            Thread.sleep( 3000)
            val intent = Intent(this, Seleccion::class.java )
            startActivity(intent)

            finish()
        }

    }
}