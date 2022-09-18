package com.kursatkumsuz.marsrealestate.repo

import androidx.lifecycle.LiveData
import com.kursatkumsuz.marsrealestate.util.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.room.MarsEntity

interface MarsRepositoryInterface {

    /**
     * Gets MarsData from API
     * @return [Resource<List<MarsModel]
     */
    suspend fun getMarsData(): Resource<List<MarsModel>>

    /**
     * Saves data to Room database
     * @param mars for save to database
     */
    suspend fun insertMars(mars: MarsEntity)

    /**
     * Delete data from Room database
     * @param mars for delete from database
     */
    suspend fun deleteMars(mars: MarsEntity)

    /**
     * Deletes all data from Room database
     */
    suspend fun deleteAllData()

    /**
     * Gets data from Room database
     * @return [LiveData<List<MarsModel]
     */
    fun getMars(): LiveData<List<MarsEntity>>
}