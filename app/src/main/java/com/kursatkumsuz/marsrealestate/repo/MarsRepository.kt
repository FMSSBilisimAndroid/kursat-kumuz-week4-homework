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

    override suspend fun insertMars(mars: MarsEntity) {
        dao.insert(mars)
    }

    override suspend fun deleteMars(mars: MarsEntity) {
        dao.delete(mars)
    }

    override suspend fun deleteAllData() {
        dao.deleteAllData()
    }

    override fun getMars(): LiveData<List<MarsEntity>> {
        return dao.getMars()
    }

}