package com.kursatkumsuz.marsrealestate.repo

import com.kursatkumsuz.marsrealestate.api.MarsApi
import com.kursatkumsuz.marsrealestate.constant.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import javax.inject.Inject

class MarsRepository @Inject constructor(
    private val api: MarsApi
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

}