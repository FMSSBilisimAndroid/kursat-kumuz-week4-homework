package com.kursatkumsuz.marsrealestate.repo

import androidx.lifecycle.LiveData
import com.kursatkumsuz.marsrealestate.constant.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel

interface MarsRepositoryInterface {

    suspend fun getMarsData(): Resource<List<MarsModel>>

}