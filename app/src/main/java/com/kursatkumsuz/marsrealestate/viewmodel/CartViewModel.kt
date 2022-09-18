package com.kursatkumsuz.marsrealestate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursatkumsuz.marsrealestate.repo.MarsRepositoryInterface
import com.kursatkumsuz.marsrealestate.room.MarsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repo: MarsRepositoryInterface
) : ViewModel() {

    val marsList = repo.getMars()

    fun deleteMars(mars: MarsEntity) = viewModelScope.launch {
        repo.deleteMars(mars)
    }

    /**
     * Deletes all data from room database
     * Runs viewModelScope for suspend function
     */
    fun deleteAllData() = viewModelScope.launch {
        repo.deleteAllData()
    }

    /**
     * Saves data to room database
     * Runs viewModelScope for suspend function
     * @param mars for save to room
     */
    private fun insertMars(mars: MarsEntity) = viewModelScope.launch {
        repo.insertMars(mars)
    }

    /**
     * Makes a object for insert to room
     * @param price MarsEntity object
     * @param id MarsEntity object
     * @param type MarsEntity object
     * @param image MarsEntity object
     */
    fun makeMars(price: Int, id: String, type: String, image: String) {
        val mars = MarsEntity(price, id, type, image)
        insertMars(mars)
    }

}