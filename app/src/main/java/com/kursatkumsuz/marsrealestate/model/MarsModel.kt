package com.kursatkumsuz.marsrealestate.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarsModel(
    val price: Int,
    val id: String,
    val type: String,
    @SerializedName("img_src")
    val image: String
) : Parcelable



