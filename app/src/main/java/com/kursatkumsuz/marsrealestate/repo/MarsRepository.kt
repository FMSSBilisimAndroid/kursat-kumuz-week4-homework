package com.kursatkumsuz.marsrealestate.repo

import androidx.lifecycle.LiveData
import com.kursatkumsuz.marsrealestate.api.MarsApi
import com.kursatkumsuz.marsrealestate.util.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.room.MarsDao
import com.kursatkumsuz.marsrealestate.room.MarsEntity
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val api: MarsApi,
    private val dao: MarsDao
) : MarsRepositoryInterface {


    /**
     * Gets MarsData from API
     * @return [Resource<List<MarsModel]
     */
    override suspend fun getMarsData(): Resource<List<MarsModel>> {
        return try {
            val response = api.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error", null)
            } else {
                Resource.error("Error", null)
            }

        } catch (e: Exception) {
            Resource.error("No Data", null)
        }
    }

    /**
     * Saves data to Room database
     * @param mars for save to database
     */
    override suspend fun insertMars(mars: MarsEntity) {
        dao.insert(mars)
    }

    /**
     * Delete data from Room database
     * @param mars for delete from database
     */
    override suspend fun deleteMars(mars: MarsEntity) {
        dao.delete(mars)
    }

    /**
     * Deletes all data from Room database
     */
    override suspend fun deleteAllData() {
        dao.deleteAllData()
    }

    /**
     * Gets data from Room database
     * @return [LiveData<List<MarsModel]
     */
    override fun getMars(): LiveData<List<MarsEntity>> {
        return dao.getMars()
    }

}