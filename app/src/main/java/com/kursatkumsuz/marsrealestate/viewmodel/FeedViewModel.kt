package com.kursatkumsuz.marsrealestate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursatkumsuz.marsrealestate.util.Resource
import com.kursatkumsuz.marsrealestate.model.MarsModel
import com.kursatkumsuz.marsrealestate.repo.MarsRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: MarsRepositoryInterface
) : ViewModel() {

    private val data = MutableLiveData<Resource<List<MarsModel>>>()
    val dataList: LiveData<Resource<List<MarsModel>>>
        get() = data

    init {
        getDataFromAPI()
    }

    /**
     * Gets data from API
     * Runs viewModelScope for suspend function
     */
    private fun getDataFromAPI() {
        data.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.getMarsData()
            data.value = response
        }
    }
}