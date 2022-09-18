package com.kursatkumsuz.marsrealestate.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kursatkumsuz.marsrealestate.model.MarsModel

@Dao
interface MarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mars: MarsEntity)

    @Delete
    suspend fun delete(mars: MarsEntity)

    @Query("DELETE FROM table_mars")
    suspend fun deleteAllData()

    @Query("SELECT * FROM table_mars")
    fun getMars(): LiveData<List<MarsEntity>>
}