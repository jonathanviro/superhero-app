package com.javr.superhero_app

import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<Superhero>
)

data class Superhero(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperheroImage
)

data class SuperheroImage(@SerializedName("url") val url: String)
