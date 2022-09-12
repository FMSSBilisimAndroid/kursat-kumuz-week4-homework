package com.kursatkumsuz.marsrealestate.model

import com.google.gson.annotations.SerializedName


data class MarsModel(
    val price: Int,
    val id: String,
    val type: String,
    @SerializedName("img_src")
    private val image: String
)

