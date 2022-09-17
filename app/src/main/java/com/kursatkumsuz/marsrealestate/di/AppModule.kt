package com.kursatkumsuz.marsrealestate.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.api.MarsApi
import com.kursatkumsuz.marsrealestate.constant.ApiConstants
import com.kursatkumsuz.marsrealestate.repo.MarsRepository
import com.kursatkumsuz.marsrealestate.repo.MarsRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrofitAPI(): MarsApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASE_URL)
            .build()
            .create(MarsApi::class.java)
    }

    @Singleton
    @Provides
    fun injectNormalRepo(api: MarsApi) =
        MarsRepository(api) as MarsRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )
}