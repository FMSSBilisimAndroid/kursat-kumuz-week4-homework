package com.kursatkumsuz.marsrealestate.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kursatkumsuz.marsrealestate.R
import com.kursatkumsuz.marsrealestate.api.MarsApi
import com.kursatkumsuz.marsrealestate.util.ApiConstants
import com.kursatkumsuz.marsrealestate.repo.MarsRepository
import com.kursatkumsuz.marsrealestate.repo.MarsRepositoryInterface
import com.kursatkumsuz.marsrealestate.room.MarsDao
import com.kursatkumsuz.marsrealestate.room.MarsDatabase
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

    /**
     * Injects RetrofitApi
     * @return [MarsApi]
     */
    @Singleton
    @Provides
    fun injectRetrofitAPI(): MarsApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASE_URL)
            .build()
            .create(MarsApi::class.java)
    }

    /**
     * Injects RoomDatabase
     * @param context for databaseBuilder
     */
    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MarsDatabase::class.java,
        "mars_database"
    ).build()

    /**
     * Injects DAO
     * @param database for access MarsDao
     */
    @Singleton
    @Provides
    fun injectDao(database: MarsDatabase) = database.marsDao()

    /**
     * Injects Repository
     * @param api for MarsRepository
     * @param dao for MarsRepository
     */
    @Singleton
    @Provides
    fun injectNormalRepo(api: MarsApi, dao: MarsDao) =
        MarsRepository(api, dao) as MarsRepositoryInterface

    /**
     * Injects Glide
     * @param context for Glide
     */
    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )
}