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

    private fun insertMars(mars: MarsEntity) = viewModelScope.launch {
        repo.insertMars(mars)
    }

    fun makeMars(price: Int, id: String, type: String, image: String) {
        val mars = MarsEntity(price, id, type, image)
        insertMars(mars)
    }

}