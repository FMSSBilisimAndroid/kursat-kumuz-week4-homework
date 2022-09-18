package com.kursatkumsuz.marsrealestate.repo

import androidx.lifecycle.LiveData
import com.kursatkumsuz.marsrealestate.util.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.room.MarsEntity

interface MarsRepositoryInterface {

    suspend fun getMarsData(): Resource<List<MarsModel>>

    suspend fun insertMars(mars : MarsEntity)

    suspend fun deleteMars(mars:MarsEntity)

    suspend fun deleteAllData()

    fun getMars() : LiveData<List<MarsEntity>>
}