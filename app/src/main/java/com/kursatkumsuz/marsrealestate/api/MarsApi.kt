package com.kursatkumsuz.marsrealestate.api

import com.kursatkumsuz.marsrealestate.util.ApiConstants
import com.kursatkumsuz.marsrealestate.model.MarsModel
import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {

    /**
     * Gets data from API
     * @return [Response<List<MarsModel>>]
     */
    @GET(ApiConstants.API)
    suspend fun getData() : Response<List<MarsModel>>
}