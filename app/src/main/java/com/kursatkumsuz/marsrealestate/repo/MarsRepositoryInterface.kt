package com.kursatkumsuz.marsrealestate.repo

import androidx.lifecycle.LiveData
import com.kursatkumsuz.marsrealestate.constant.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.room.MarsEntity

interface MarsRepositoryInterface {

    suspend fun getMarsData(): Resource<List<MarsModel>>

    suspend fun insertMars(mars : MarsEntity)

    suspend fun deleteMars(mars:MarsEntity)

    fun getMars() : LiveData<List<MarsEntity>>
}