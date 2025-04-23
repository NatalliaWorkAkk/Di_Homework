package com.effectivemobile.faeture_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.effectivemobile.faeture_home.domain.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel (private val repository: NetworkRepository) : ViewModel() {

    val networkResult = MutableStateFlow<String?>(null)

    init {
        getTestFakeRequest()
        getProdFakeRequest()
    }

    fun getTestFakeRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            networkResult.tryEmit(repository.getTestNetworkResult())
        }
    }

    fun getProdFakeRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            networkResult.tryEmit(repository.getProdNetworkResult())
        }
    }

    class HomeViewModelProvider @Inject constructor(private val repository: NetworkRepository) :
        ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            } else throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}