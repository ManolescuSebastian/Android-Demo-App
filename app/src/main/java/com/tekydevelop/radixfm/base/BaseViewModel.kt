package com.tekydevelop.radixfm.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

abstract class BaseViewModel : ViewModel() {

    val error: LiveData<String> get() = _error
    private val _error = MutableLiveData<String>()

    fun <T> Flow<T>.handleErrors(): Flow<T> = flow {
        try {
            collect { value -> emit(value) }
        } catch (e: Throwable) {
            _error.value = "last.fm data not available"
        }
    }
}