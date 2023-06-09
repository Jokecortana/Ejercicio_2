package com.example.ejercicio_2.model

import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("actor")
    var actor: String?

)
