package com.example.ejercicio_2.model

import com.google.gson.annotations.SerializedName

data class PersonajeDetail(
    @SerializedName("id")
    var id: String?,
    @SerializedName("species")
    var species: String?,
    @SerializedName("house")
    var house: String?,
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("dateOfBirth")
    var dateOfBirth: String?,
    @SerializedName("ancestry")
    var ancestry: String?,
    @SerializedName("patronus")
    var patronus: String?,
    @SerializedName("name")
var name: String?,
    @SerializedName("image")
    var image: String?


)
