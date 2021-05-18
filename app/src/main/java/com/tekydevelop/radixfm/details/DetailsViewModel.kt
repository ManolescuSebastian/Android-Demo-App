package com.tekydevelop.radixfm.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tekydevelop.domain.model.details.AlbumInfoResult
import com.tekydevelop.domain.usecase.AlbumDetailsUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DetailsViewModel(private val albumDetailsUseCase: AlbumDetailsUseCase) : ViewModel() {

    val albumInfoResult: LiveData<AlbumInfoResult> get() = _albumInfoResult
    private val _albumInfoResult = MutableLiveData<AlbumInfoResult>()

    val error: LiveData<String> get() = _error
    private val _error = MutableLiveData<String>()

    fun getAlbumDetails(mbid: String) {
        viewModelScope.launch {
            albumDetailsUseCase.getAlbumDetails(mbid).onStart {

            }.catch { e ->
                _error.value = e.localizedMessage
            }.collect {
                _albumInfoResult.value = it
            }
        }
    }
}