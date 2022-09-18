package com.kursatkumsuz.marsrealestate.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_mars")
data class MarsEntity(
    val price: Int,
    val id: String,
    val type: String,
    val image: String,
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int? = null
)
