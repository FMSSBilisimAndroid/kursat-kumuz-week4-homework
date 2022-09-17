package com.kursatkumsuz.marsrealestate.api

import com.kursatkumsuz.marsrealestate.constant.ApiConstants
import com.kursatkumsuz.marsrealestate.model.MarsModel
import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {

    @GET(ApiConstants.API)
    suspend fun getData() : Response<List<MarsModel>>
}