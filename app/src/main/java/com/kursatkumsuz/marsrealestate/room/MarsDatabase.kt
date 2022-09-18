package com.kursatkumsuz.marsrealestate.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kursatkumsuz.marsrealestate.model.MarsModel

@Database(entities = [MarsEntity::class], version = 1, exportSchema = false)
abstract class MarsDatabase : RoomDatabase() {

    abstract fun marsDao(): MarsDao
}