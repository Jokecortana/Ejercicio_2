package com.example.ejercicio_2.network

import android.telecom.Call
import com.example.ejercicio_2.model.Personaje
import com.example.ejercicio_2.model.PersonajeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import javax.security.auth.callback.Callback

interface PersonajeApi {

    @GET
    fun getPerson(
        @Url url: String? = null
    ): retrofit2.Call<java.util.ArrayList<Personaje>>


 @GET("api/character/{id}")
 fun getPersonDetail (
   @Path("id") id:String?

 ): retrofit2.Call<PersonajeDetail>

}